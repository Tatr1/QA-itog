package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class Sql {
    QueryRunner runner = new QueryRunner();
    static String url = "jdbc:mysql://localhost:3300/app";
    static String login = "app";
    static String password = "pass";
    static String statusPayment = "SELECT status FROM payment_entity;";
    static String statusCredit = "SELECT status FROM credit_request_entity;";
    static String countOrderEntity = "SELECT id FROM order_entity;";
    static String deletePayment = "DELETE FROM payment_entity;";
    static String deleteCredit = "DELETE FROM credit_request_entity;";
    static String deleteOrder = "DELETE FROM order_entity;";

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
    public static String sqlQueryPaymentStatus() {
        var runner = new QueryRunner();
        TimeUnit.SECONDS.sleep(10);
        try (
                var connection = DriverManager.getConnection(url, login, password);
        ) {
            String sqlPayment = runner.query(connection, statusPayment, new ScalarHandler<>());
            return sqlPayment;
        }
    }

    @SneakyThrows
    public static String sqlQueryCreditStatus() {
        var runner = new QueryRunner();
        TimeUnit.SECONDS.sleep(10);
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
        ) {
            String sqlCredit = runner.query(connection, statusCredit, new ScalarHandler<>());
            return sqlCredit;
        }
    }

    @SneakyThrows
    public static Integer sqlQueryOrderEntity() {
        var runner = new QueryRunner();
        TimeUnit.SECONDS.sleep(10);
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
        ) {
            Integer sqlOrder = runner.query(connection, countOrderEntity, new ScalarHandler<>());
            return sqlOrder;
        }
    }
}

