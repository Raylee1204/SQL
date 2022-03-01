USE [KekaiBB]
GO

/****** Object:  Table [dbo].[finally]    Script Date: 2021/1/10 ¤U¤È 03:00:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[finally](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[no_1] [int] NOT NULL,
	[no_2] [int] NOT NULL,
	[no_3] [int] NOT NULL,
	[no_4] [int] NOT NULL,
	[no_5] [int] NOT NULL,
	[no_6] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


