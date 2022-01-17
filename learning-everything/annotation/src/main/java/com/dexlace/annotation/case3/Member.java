package com.dexlace.annotation.case3;

/**
 * 我们的目的就是为该javabean生成一个创建表的语句
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30,
            constraints = @Constrains(primaryKey = true))
    String handle;

    static int memberCount;

}

