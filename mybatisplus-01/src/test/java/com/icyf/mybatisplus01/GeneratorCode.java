package com.icyf.mybatisplus01;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Author: ESy
 * @Date: 2020/6/29 15:37
 */
public class GeneratorCode {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/mybatisplus-01/src/main/java");
        gc.setAuthor("ESy");
        gc.setOpen(false);
        gc.setFileOverride(false); //是否覆盖
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplue?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("971234");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3.包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.icyf.mybatisplus01");
        pc.setModuleName("mybatisplus02");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4.策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user");
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true); //开启lombok
        sc.setLogicDeleteFieldName("deleted");
        //自动填充策略
        TableFill gmt_create = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("modified_time", FieldFill.INSERT);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        sc.setTableFillList(tableFills);
        //乐观锁配置
        sc.setVersionFieldName("version");

        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(sc);

        mpg.execute();

    }
}
