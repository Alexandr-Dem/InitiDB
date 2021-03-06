USE [master]
GO
/****** Object:  Database [Sushi]    Script Date: 27.02.2020 16:47:17 ******/
CREATE DATABASE [Sushi]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Sushi_test', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\Sushi_test.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Sushi_test_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\Sushi_test_log.ldf' , SIZE = 139264KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Sushi] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Sushi].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Sushi] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Sushi] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Sushi] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Sushi] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Sushi] SET ARITHABORT OFF 
GO
ALTER DATABASE [Sushi] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Sushi] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Sushi] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Sushi] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Sushi] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Sushi] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Sushi] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Sushi] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Sushi] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Sushi] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Sushi] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Sushi] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Sushi] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Sushi] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Sushi] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Sushi] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Sushi] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Sushi] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Sushi] SET  MULTI_USER 
GO
ALTER DATABASE [Sushi] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Sushi] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Sushi] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Sushi] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Sushi] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Sushi] SET QUERY_STORE = OFF
GO
USE [Sushi]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [Sushi]
GO
/****** Object:  Table [dbo].[CashSession]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CashSession](
	[id] [uniqueidentifier] NOT NULL,
	[sessionNumber] [int] NOT NULL,
	[fiscalNumber] [int] NOT NULL,
	[cashRegNumber] [int] NULL,
	[cashRegSerial] [int] NULL,
	[operationDate] [date] NOT NULL,
	[openDate] [datetime] NOT NULL,
	[closeDate] [datetime] NOT NULL,
	[acceptDate] [datetime] NULL,
	[managerId] [uniqueidentifier] NULL,
	[responsibleUserId] [uniqueidentifier] NULL,
	[sessionStartCash] [decimal](8, 1) NOT NULL,
	[payOrders] [decimal](8, 1) NOT NULL,
	[sumWriteoffOrders] [decimal](8, 1) NOT NULL,
	[salesCash] [decimal](8, 1) NOT NULL,
	[salesCredit] [decimal](8, 1) NOT NULL,
	[salesCard] [decimal](8, 1) NOT NULL,
	[payIn] [decimal](8, 1) NOT NULL,
	[payOut] [decimal](8, 1) NOT NULL,
	[payIncome] [decimal](8, 1) NOT NULL,
	[cashRemain] [decimal](8, 1) NOT NULL,
	[cashDiff] [decimal](8, 1) NOT NULL,
	[sessionStatus] [nvarchar](20) NOT NULL,
	[conceptionId] [uniqueidentifier] NOT NULL,
	[pointOfSaleId] [uniqueidentifier] NOT NULL,
	[processedCashName] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_CashShifts] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departments](
	[id] [uniqueidentifier] NOT NULL,
	[alias] [char](3) NOT NULL,
 CONSTRAINT [PK_Departments] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nomenclature]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nomenclature](
	[id] [uniqueidentifier] NOT NULL,
	[code] [int] NOT NULL,
	[num] [int] NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[category] [uniqueidentifier] NULL,
	[accountingCategory] [uniqueidentifier] NULL,
	[deleted] [bit] NOT NULL,
	[type] [nvarchar](8) NOT NULL,
	[defaultSalePrice] [decimal](6, 1) NOT NULL,
	[parent] [uniqueidentifier] NULL,
 CONSTRAINT [PK_Nomenclature] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrdersItems]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrdersItems](
	[id] [uniqueidentifier] NOT NULL,
	[salesCSId] [uniqueidentifier] NOT NULL,
	[nomenclatureId] [uniqueidentifier] NOT NULL,
	[dishServicePrintTime] [datetime] NOT NULL,
	[amount] [int] NOT NULL,
	[fullSum] [int] NOT NULL,
	[resultSum] [int] NOT NULL,
	[discountSum] [int] NOT NULL,
	[fullPrice] [int] NOT NULL,
	[resultPrice] [int] NOT NULL,
 CONSTRAINT [PK_OrdersItems] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payments]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payments](
	[id] [uniqueidentifier] NOT NULL,
	[salesCSId] [uniqueidentifier] NOT NULL,
	[name] [nchar](30) NOT NULL,
	[paymentGroup] [nchar](30) NULL,
	[paymentSum] [int] NOT NULL,
	[paymentSumRaw] [int] NOT NULL,
 CONSTRAINT [PK_Payments] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PointsOfSale]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PointsOfSale](
	[id] [uniqueidentifier] NOT NULL,
	[departmentId] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK_PointsOfSale] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesCS]    Script Date: 27.02.2020 16:47:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalesCS](
	[id] [uniqueidentifier] NOT NULL,
	[number] [int] NOT NULL,
	[serviceType] [nvarchar](50) NOT NULL,
	[deliveryExpectedTime] [datetime] NULL,
	[openTime] [datetime] NOT NULL,
	[deliveryPrintTime] [datetime] NULL,
	[dishServicePrintTime] [datetime] NOT NULL,
	[cookingFinishTime] [datetime] NULL,
	[billTime] [datetime] NULL,
	[sendTime] [datetime] NULL,
	[actualTime] [datetime] NULL,
	[closeTime] [datetime] NOT NULL,
	[deliveryCloseTime] [datetime] NULL,
	[sum] [int] NOT NULL,
	[resultSum] [int] NOT NULL,
	[discountSum] [int] NOT NULL,
	[discount] [nvarchar](50) NOT NULL,
	[cashnumber] [int] NOT NULL,
	[cashname] [nvarchar](50) NOT NULL,
	[conception] [nvarchar](50) NULL,
	[hashcode] [int] NOT NULL,
	[operationType] [nvarchar](50) NOT NULL,
	[storned] [bit] NOT NULL,
	[cashSessionId] [uniqueidentifier] NOT NULL,
	[typeName] [nvarchar](50) NOT NULL,
	[phone] [varchar](16) NULL,
	[operatorId] [uniqueidentifier] NULL,
	[courierId] [uniqueidentifier] NULL,
	[departmentId] [uniqueidentifier] NULL,
 CONSTRAINT [PK__SalesCS__3213E83F265A9672] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Payments] ADD  CONSTRAINT [DF_Payments_id]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[CashSession]  WITH CHECK ADD  CONSTRAINT [FK_CashSession_PointsOfSale] FOREIGN KEY([pointOfSaleId])
REFERENCES [dbo].[PointsOfSale] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CashSession] CHECK CONSTRAINT [FK_CashSession_PointsOfSale]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [FK_OrdersItems_Nomenclature] FOREIGN KEY([nomenclatureId])
REFERENCES [dbo].[Nomenclature] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [FK_OrdersItems_Nomenclature]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [FK_OrdersItems_SalesCS] FOREIGN KEY([salesCSId])
REFERENCES [dbo].[SalesCS] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [FK_OrdersItems_SalesCS]
GO
ALTER TABLE [dbo].[Payments]  WITH CHECK ADD  CONSTRAINT [FK_Payments_SalesCS] FOREIGN KEY([salesCSId])
REFERENCES [dbo].[SalesCS] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Payments] CHECK CONSTRAINT [FK_Payments_SalesCS]
GO
ALTER TABLE [dbo].[PointsOfSale]  WITH CHECK ADD  CONSTRAINT [FK_PointsOfSale_Departments] FOREIGN KEY([departmentId])
REFERENCES [dbo].[Departments] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PointsOfSale] CHECK CONSTRAINT [FK_PointsOfSale_Departments]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [FK_SalesCS_CashShifts] FOREIGN KEY([cashSessionId])
REFERENCES [dbo].[CashSession] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [FK_SalesCS_CashShifts]
GO
ALTER TABLE [dbo].[CashSession]  WITH CHECK ADD  CONSTRAINT [fiscalNumber_greater_zero] CHECK  (([fiscalNumber]>(0)))
GO
ALTER TABLE [dbo].[CashSession] CHECK CONSTRAINT [fiscalNumber_greater_zero]
GO
ALTER TABLE [dbo].[CashSession]  WITH CHECK ADD  CONSTRAINT [sessionNumber_greater_zero] CHECK  (([sessionNumber]>(0)))
GO
ALTER TABLE [dbo].[CashSession] CHECK CONSTRAINT [sessionNumber_greater_zero]
GO
ALTER TABLE [dbo].[Departments]  WITH CHECK ADD  CONSTRAINT [alias_check] CHECK  (([alias]='msk' OR [alias]='rst'))
GO
ALTER TABLE [dbo].[Departments] CHECK CONSTRAINT [alias_check]
GO
ALTER TABLE [dbo].[Nomenclature]  WITH CHECK ADD  CONSTRAINT [code_check_greater_zero] CHECK  (([code]>(0)))
GO
ALTER TABLE [dbo].[Nomenclature] CHECK CONSTRAINT [code_check_greater_zero]
GO
ALTER TABLE [dbo].[Nomenclature]  WITH CHECK ADD  CONSTRAINT [defaultSalePrice_check_greater_or_equals_zero] CHECK  (([defaultSalePrice]>=(0)))
GO
ALTER TABLE [dbo].[Nomenclature] CHECK CONSTRAINT [defaultSalePrice_check_greater_or_equals_zero]
GO
ALTER TABLE [dbo].[Nomenclature]  WITH CHECK ADD  CONSTRAINT [num_check_greater_zero] CHECK  (([num]>(0)))
GO
ALTER TABLE [dbo].[Nomenclature] CHECK CONSTRAINT [num_check_greater_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [amount_check_greater_zero] CHECK  (([amount]>(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [amount_check_greater_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [discountSum_OrderItems_check_greater_equals_zero] CHECK  (([discountSum]>=(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [discountSum_OrderItems_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [fullPrice_check_greater_equals_zero] CHECK  (([fullPrice]>=(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [fullPrice_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [fullSum_check_greater_equals_zero] CHECK  (([fullSum]>=(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [fullSum_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [resultPrice_check_greater_equals_zero] CHECK  (([resultPrice]>=(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [resultPrice_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[OrdersItems]  WITH CHECK ADD  CONSTRAINT [resultSum_OrderItems_check_greater_equals_zero] CHECK  (([resultSum]>=(0)))
GO
ALTER TABLE [dbo].[OrdersItems] CHECK CONSTRAINT [resultSum_OrderItems_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[Payments]  WITH CHECK ADD  CONSTRAINT [paymentSum_greater_equals_zero] CHECK  (([paymentSum]>=(0)))
GO
ALTER TABLE [dbo].[Payments] CHECK CONSTRAINT [paymentSum_greater_equals_zero]
GO
ALTER TABLE [dbo].[Payments]  WITH CHECK ADD  CONSTRAINT [paymentSumRaw_greater_equals_zero] CHECK  (([paymentSumRaw]>=(0)))
GO
ALTER TABLE [dbo].[Payments] CHECK CONSTRAINT [paymentSumRaw_greater_equals_zero]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [cashnumber_check_greater_equals_zero] CHECK  (([cashnumber]>=(0)))
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [cashnumber_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [discountSum_check_greater_equals_zero] CHECK  (([discountSum]>=(0)))
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [discountSum_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [number_check_greater_equals_zero] CHECK  (([number]>=(0)))
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [number_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [resultSum_check_greater_equals_zero] CHECK  (([resultSum]>=(0)))
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [resultSum_check_greater_equals_zero]
GO
ALTER TABLE [dbo].[SalesCS]  WITH CHECK ADD  CONSTRAINT [sum_check_greater_equals_zero] CHECK  (([sum]>=(0)))
GO
ALTER TABLE [dbo].[SalesCS] CHECK CONSTRAINT [sum_check_greater_equals_zero]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Кассовые смены' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'CashSession'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Филиалы' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Departments'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'точки продажи' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PointsOfSale'
GO
USE [master]
GO
ALTER DATABASE [Sushi] SET  READ_WRITE 
GO
