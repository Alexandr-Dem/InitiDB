package com.alexanderdem.gui;

import com.alexanderdem.InitDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JTextArea outputTextArea;
    private JScrollPane scrollOutputTextArea;
    private JComboBox<String> aliasComboBox;
    private JComboBox<String> dateComboBox;
    private JButton handleButton;
    private JCheckBox loadAllCheckBox;
    private InitDB initDB;
    private boolean mayShow = true;

    public Window(InitDB initDB) {
        this.initDB = initDB;

        setLayout(new GridBagLayout());
        setSize(546, 455);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("initDB");

        initComponents();
        drawComponents();

        setVisible(true);
    }

    private void initComponents() {
        outputTextArea = new JTextArea(20, 45);
        outputTextArea.setEditable(false);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setText("Подождите...\n");

        scrollOutputTextArea = new JScrollPane(outputTextArea);
        scrollOutputTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollOutputTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollOutputTextArea.getVerticalScrollBar().setUnitIncrement(
                scrollOutputTextArea.getVerticalScrollBar().getUnitIncrement() * 13);

        aliasComboBox = new JComboBox<String>(new String[]{"msk", "rst"});

        dateComboBox = new JComboBox<String>(new String[]{
                "2020.01.01", "2020.01.02", "2020.01.03", "2020.01.04", "2020.01.05",
                "2020.01.06", "2020.01.07", "2020.01.08", "2020.01.09", "2020.01.10"
        });

        handleButton = new JButton("Обработать");
        handleButton.setEnabled(false);
        handleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (loadAllCheckBox.isSelected()) {
                            loadAll();
                        } else {
                            start();
                        }
                    }
                }).start();
            }
        });
        loadAllCheckBox = new JCheckBox("load all");
        loadAllCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loadAllCheckBox.isSelected()) {
                    aliasComboBox.setEnabled(false);
                    dateComboBox.setEnabled(false);
                } else {
                    aliasComboBox.setEnabled(true);
                    dateComboBox.setEnabled(true);
                }
            }
        });
    }

    private void drawComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7, 5, 7, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Выберете филиал и дату: "));
        c.gridx++;
        add(aliasComboBox, c);
        c.gridx++;
        add(dateComboBox, c);
        c.gridx++;
        add(loadAllCheckBox, c);
        c.gridx++;
        add(handleButton, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 5;
        add(scrollOutputTextArea, c);
    }

    //Делает доступным нажатие на кнопку Обработать
    public void ready() {
        handleButton.setEnabled(true);
    }

    //Запускает инициализацию всей базы данных
    private void loadAll() {
        aliasComboBox.setSelectedIndex(0);
        dateComboBox.setSelectedIndex(0);
        showMessage("Загружаю всю информацию в базу данных. Подождите.\n\n");
        mayShow = false;
        for (int i = 0; i < 20; i++) {
            start();
            mayShow = true;
            showMessage("Обработаны данные по филиалу '" + aliasComboBox.getSelectedItem() + "' и дате: " + dateComboBox.getSelectedItem() + "\n");
            mayShow = false;
            if (i == 9) {
                aliasComboBox.setSelectedIndex(1);
                dateComboBox.setSelectedIndex(0);
            } else {
                if (i < 19) dateComboBox.setSelectedIndex(dateComboBox.getSelectedIndex() + 1);
            }
        }
        mayShow = true;
        showMessage("Вся база данных была загуженна.\n\n");
        showExample();
    }

    //Запускает инициализацию базы для определенного дня и филиала
    private void start() {
        handleButton.setEnabled(false);
        String alias = (String) aliasComboBox.getSelectedItem();
        String date = ((String) dateComboBox.getSelectedItem()).replace(".", "-");
        initDB.go(alias, date);
        showExample();
        handleButton.setEnabled(true);
        scrollOutputTextArea.getVerticalScrollBar().setValue(scrollOutputTextArea.getVerticalScrollBar().getMaximum());
        repaint();
    }


    public void showMessage(String message) {
        if (!mayShow) return;
        outputTextArea.append(message);
        //Костыли Swing'a что бы более коректно отображалcя наш текст и продвигался скролл
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scrollOutputTextArea.getVerticalScrollBar().setValue(scrollOutputTextArea.getVerticalScrollBar().getMaximum());
        repaint();
    }

    private void showExample() {
        showMessage("Инициализация завершена, можете проверить SQL-запросом:\n\n");
        showMessage("SELECT * FROM(\n" +
                "SELECT 'Deportament' [Table],count(*) [count]  FROM Departments UNION \n" +
                "SELECT 'PointsOfSale',count(*) FROM PointsOfSale UNION \n" +
                "SELECT 'CashSession' ,count(*) FROM CashSession UNION \n" +
                "SELECT 'SalesCS' ,count(*) FROM SalesCS UNION \n" +
                "SELECT 'Payments' ,count(*) FROM Payments UNION \n" +
                "SELECT 'OrdersItems' ,count(*) FROM OrdersItems  UNION \n" +
                "SELECT 'Nomenclature' ,count(*) FROM Nomenclature ) T\n" +
                "ORDER BY [count]\n\n" +
                "Очистить базу данных можете SQL-командой:\n" +
                "DELETE FROM Departments" +
                "\n\n");
    }
}
