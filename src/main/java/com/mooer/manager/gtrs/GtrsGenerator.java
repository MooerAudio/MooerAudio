//package com.mooer.manager.gtrs;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
//public class GtrsGenerator {
//	private static GtrsGenerator single = null;
//
//	private GtrsGenerator() {
//		super();
//	}
//
//	private static GtrsGenerator getSingle() {
//		if (single == null) {
//			single = new GtrsGenerator();
//		}
//		return single;
//	}
//
//	public void autoGeneration() {
//		// 1.全局配置
//		GlobalConfig globalConfig = new GlobalConfig();
//		globalConfig.setActiveRecord(true)// 是否开启AR模式
//				.setAuthor("main") // 指定作者
//				.setOutputDir("src\\main\\java").setFileOverride(false) // 指定文件覆盖
//				.setServiceImplName("%sService") // 设置生成的services接口的名字的首字母是否为I
//				.setBaseResultMap(true) // 基本的字段映射
//				.setBaseColumnList(true); // 基本的sql片段
//		// 2.配置数据源
//		DataSourceConfig dataSourceConfig = new DataSourceConfig();
//		dataSourceConfig.setUrl("jdbc:mysql://192.168.100.99:3306/m_gtrs")//
//				.setUsername("root")//
//				.setPassword("root")//
//				.setDriverName("com.mysql.jdbc.Driver").setTypeConvert(new MySqlTypeConvert() {
//					                    @Override
//					                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
//					                        System.out.println("转换类型：" + fieldType);
//					                         //将数据库中datetime转换成date
//					                        if ( fieldType.toLowerCase().contains( "datetime" ) ) {
//					                            return DbColumnType.TIMESTAMP;
//					                        }
//					                        if ( fieldType.toLowerCase().contains( "date" ) ) {
//					                            return DbColumnType.TIMESTAMP;
//					                        }
//					                        if ( fieldType.toLowerCase().contains( "timestamp" ) ) {
//					                            return DbColumnType.TIMESTAMP;
//					                        }
//					                        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
//					                    }
//					                });
////				.setTypeConvert(new PostgreSqlTypeConvert() {
////					@Override
////					public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
////						String t = fieldType.toLowerCase();
////						if (t.contains("date") || t.contains("time")) {
////							switch (globalConfig.getDateType()) {
////							case ONLY_DATE:
////								return DbColumnType.DATE;
////							case SQL_PACK:
////								switch (t) {
////								case "date":
////									return DbColumnType.DATE_SQL;
////								case "time":
////									return DbColumnType.TIME;
////								default:
////									return DbColumnType.TIMESTAMP;
////								}
////							case TIME_PACK:
////								switch (t) {
////								case "date":
////									return DbColumnType.LOCAL_DATE;
////								case "time":
////									return DbColumnType.LOCAL_TIME;
////								default:
////									return DbColumnType.TIMESTAMP;
////								}
////							default:
////								return DbColumnType.DATE;
////							}
////						} else {
////							return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
////						}
////					}
////				});
////				.setTypeConvert(new MySqlTypeConvert() {
////					                    @Override
////					                    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
////					                        System.out.println("转换类型：" + fieldType);
////					                        //tinyint转换成Boolean
////					                         if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
////					                            return DbColumnType.BOOLEAN;
////					                         }
////					                         //将数据库中datetime转换成date
////					                        if ( fieldType.toLowerCase().contains( "datetime" ) ) {
////					                            return DbColumnType.DATE;
////					                        }
////					                        return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
////					                    }
////					                });
//		// 3.策略配置
//		StrategyConfig strategyConfig = new StrategyConfig();
//		strategyConfig.setCapitalMode(true) // 全局大写命名
//				.setNaming(NamingStrategy.underline_to_camel) // 数据库字段下划线转驼峰命令策略
//				.setTablePrefix("m_") // 设置表前缀
//				.setInclude(//
//						"m_goods_desc"
//						); // 设置需要生成的表
//		// 4.包名策略配置
//		PackageConfig packageConfig = new PackageConfig();
//		packageConfig.setParent("com.mooer.manager.gtrs") // 设置父包
//				.setMapper("mapper").setEntity("pojo").setXml("sql");
//		// 5. 开始生成代码
//		AutoGenerator autoGenerator = new AutoGenerator();
//		autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
//				.setPackageInfo(packageConfig);
//		autoGenerator.execute();
//	}
//
//	public static void main(String[] args) {
//		GtrsGenerator generator = GtrsGenerator.getSingle();
//		generator.autoGeneration();
//	}
//}
