package com.zenika.vhr.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.zenika.vhr")
public class BCArchTest {


    @ArchTest
    public static final ArchRule maintenanceBC = classes()
            .that().resideInAPackage("com.zenika.vhr.maintenance..")
            .should().onlyBeAccessed().byAnyPackage("com.zenika.vhr.maintenance..");

}