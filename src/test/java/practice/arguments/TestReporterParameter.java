package practice.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

class TestReporterParameter {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        // テスト実行に関する情報を公開するためのものらしい。
        // IDEでテストクラスを実行すると以下の内容が標準出力に出力された。
        // timestamp = 2018-06-10T20:21:35.606183, a key = a value
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void reportSeveralValues(TestReporter testReporter) {
        // 複数の情報をまとめて公開できる
        // IDEでテストクラスを実行すると以下の内容が標準出力に出力された。
        // timestamp = 2018-06-10T20:26:22.246823, user name = dk38, award year = 1974
        HashMap<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }
}
