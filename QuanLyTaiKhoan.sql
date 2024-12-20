USE [QuanLyTaiKhoan]
GO
/****** Object:  Table [dbo].[ChiTietTaiKhoan]    Script Date: 12/2/2024 2:44:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTaiKhoan](
	[NgayRutTien] [date] NULL,
	[SoTienRutRa] [bigint] NULL,
	[SoTaiKhoan] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
	[HoTen] [nvarchar](50) NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Taikhoan]    Script Date: 12/2/2024 2:44:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Taikhoan](
	[SoTaiKhoan] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[SoTien] [bigint] NULL,
	[MatKhau] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Taikhoan] PRIMARY KEY CLUSTERED 
(
	[SoTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] ON 

INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-11' AS Date), 4000, N'duccap123', NULL, N'Truong Bui Nguyen Duc', 1)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 2000, N'thanhlich', NULL, N'Tran Van Thanh', 2)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, N'duccap123', NULL, N'Truong Bui Nguyen Duc', 4)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, N'duccap123', NULL, N'Truong Bui Nguyen Duc', 5)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, NULL, NULL, N'Truong Bui Nguyen Duc', 6)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, NULL, NULL, N'Truong Bui Nguyen Duc', 7)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, NULL, NULL, N'Truong Bui Nguyen Duc', 8)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 4000, NULL, NULL, N'Truong Bui Nguyen Duc', 9)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 100000, N'duccap123', NULL, N'Truong Bui Nguyen Duc', 12)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 200000, N'thanhlich', NULL, N'Tran Van Thanh', 14)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 200000, N'thanhlich', NULL, N'Tran Van Thanh', 18)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 200000, N'thanhlich', NULL, N'Tran Van Thanh', 22)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 1000000, N'thanhlich', NULL, N'Tran Van Thanh', 24)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 500000, NULL, NULL, N'Truong Bui Nguyen Duc', 10)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 500000, N'thanhlich', NULL, N'Tran Van Thanh', 19)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 123456, N'thanhlich', NULL, N'Tran Van Thanh', 21)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 500000, N'thanhlich', NULL, N'Tran Van Thanh', 23)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 500000, NULL, NULL, N'Truong Bui Nguyen Duc', 11)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 2000000, N'thanhlich', NULL, N'Tran Van Thanh', 15)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 6000, N'thanhlich', NULL, N'Tran Van Thanh', 16)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 200000, N'thanhlich', NULL, N'Tran Van Thanh', 17)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 100000, N'thanhlich', NULL, N'Tran Van Thanh', 25)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 8000, N'thanhlich', NULL, N'Tran Van Thanh', 26)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 40000, N'duccap123', NULL, N'Truong Bui Nguyen Duc', 27)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 2000, N'thanhlich', NULL, N'Tran Van Thanh', 13)
INSERT [dbo].[ChiTietTaiKhoan] ([NgayRutTien], [SoTienRutRa], [SoTaiKhoan], [GhiChu], [HoTen], [Id]) VALUES (CAST(N'2024-11-12' AS Date), 200000, N'thanhlich', NULL, N'Tran Van Thanh', 20)
SET IDENTITY_INSERT [dbo].[ChiTietTaiKhoan] OFF
GO
INSERT [dbo].[Taikhoan] ([SoTaiKhoan], [HoTen], [SoTien], [MatKhau], [TrangThai]) VALUES (N'duccap123', N'Truong Bui Nguyen Duc', 921101500, N'123', 1)
INSERT [dbo].[Taikhoan] ([SoTaiKhoan], [HoTen], [SoTien], [MatKhau], [TrangThai]) VALUES (N'thanhlich', N'Tran Van Thanh', 24977989, N'123', 0)
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTaiKhoan_Taikhoan1] FOREIGN KEY([SoTaiKhoan])
REFERENCES [dbo].[Taikhoan] ([SoTaiKhoan])
GO
ALTER TABLE [dbo].[ChiTietTaiKhoan] CHECK CONSTRAINT [FK_ChiTietTaiKhoan_Taikhoan1]
GO
