package ru.netology;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.DriverManager;

public class Sql {
    QueryRunner runner = new QueryRunner();
    static String url = "jdbc:mysql://localhost:3300/app";
    static String login = "app";
    static String password = "pass";
    static String statusPayment = "SELECT status FROM payment_entity;";
    static String statusCredit = "SELECT status FROM credit_request_entity;";
    static String amount = "SELECT amount FROM payment_entity;";
    static String deletePayment = "DELETE from payment_entity;";
    static String deleteCredit = "Delete from credit_request_entity;";
    static String deleteOrder = "Delete from order_entity;";
//    var countOrderEntity = "Select count(*) from order_entity;";

    public Sql() {
    }

    @SneakyThrows
    public static void sqlCleanStatus() {
        QueryRunner runner = new QueryRunner();
        try (
                var connection = DriverManager.getConnection(url, login, password);

        ) {
            runner.update(connection, deletePayment);
            runner.update(connection, deleteCredit);
            runner.update(connection, deleteOrder);
        }
    }

    @SneakyThrows
    public String sqlQueryPaymentStatus() {
        var runner = new QueryRunner();
        try (
                var connection = DriverManager.getConnection("jdbc:mysql://localhost:3300/app", "app", "pass");
        ) {
            String sqlPayment = runner.query(connection, statusPayment, new ScalarHandler<>());
            return sqlPayment;
        }

    }

    @SneakyThrows
    public String sqlQueryCreditStatus() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3300/app", "app", "pass");
        ) {
            String sqlCredit = runner.query(connection, statusCredit, new ScalarHandler<>());
            return sqlCredit;
        }
    }

    @SneakyThrows
    public Integer sqlQueryPaymentAmount() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3300/app", "app", "pass");
        ) {
            Integer sqlAmount = runner.query(connection, amount, new ScalarHandler<>());
            return sqlAmount;
        }
    }
}

