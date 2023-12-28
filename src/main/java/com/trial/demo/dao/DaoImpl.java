package com.trial.demo.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.sql.DataSource;
import javax.xml.bind.DatatypeConverter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trial.demo.domain.SignInDto;
import com.trial.demo.domain.SignUpDto;

@Repository
@Transactional
public class DaoImpl implements Dao {
    private static final String SIGN_UP = "{ ? = call sign_up(?,?,?,?)}";
    private static final String SIGN_IN = "{ ? = call sign_in(?,?)}";

    private final JdbcTemplate jdbcTemplate;

    public DaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String signUpDao(SignUpDto signUp) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(signUp.getPassword().getBytes());
        byte[] digest = md.digest();
        String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();
        jdbcTemplate.execute("SET SCHEMA 'demo_schema'");

        return jdbcTemplate.execute((Connection con) -> {
            CallableStatement cs = con.prepareCall(SIGN_UP);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, signUp.getEmail());
            cs.setString(3, signUp.getFirstName());
            cs.setString(4, signUp.getLastName());
            cs.setString(5, hashedPassword);
            return cs;
        }, (CallableStatement cs) -> {
            cs.execute();

            return cs.getString(1);

        });
    }

    public String signInDao(SignInDto signIn) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(signIn.getPassword().getBytes());
        byte[] digest = md.digest();
        String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();
        jdbcTemplate.execute("SET SCHEMA 'demo_schema'");

        return jdbcTemplate.execute((Connection con) -> {
            CallableStatement cs = con.prepareCall(SIGN_IN);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, signIn.getEmail());
            cs.setString(3, hashedPassword);
            return cs;
        }, (CallableStatement cs) -> {
            cs.execute();

            return cs.getString(1);

        });
    }

}
