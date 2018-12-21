package com.sakura.rain;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc 词云分析
 * @date 2018-12-21
 */
public class KennyCasonApplication {
    public static void main(String[] args) throws Exception {

        // sqlite connection init
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");

        //Vocabulary analyzer set analysis parameters
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);

        //Chinese analysis
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());

        // query all comments from db
        String query_sql = "select comment from aquaman";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query_sql);
        List<String> commentList = new ArrayList<>();
        while (resultSet.next()) {
            commentList.add(resultSet.getObject(1).toString());
        }

        // load the comment in the db
        List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(commentList);

        // Set resolution
        Dimension dimension = new Dimension(600,600);
        WordCloud wc = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);

        wc.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);

        wc.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wc.setKumoFont(new KumoFont(font));
        wc.setBackgroundColor(new Color(209, 211, 215));
        wc.build(wordFrequencyList);
        wc.writeToFile("aquaman.png");
    }
}
