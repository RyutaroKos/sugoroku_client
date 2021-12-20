package com.data;

public enum Request {
    LOGIN, SIGNUP, //トップパネルコマンド
    RANDOM_MATCH, PRIVATE_MATCH, CHECK_RECORD, //マッチングパネルコマンド
    EXIT_LOBBY, START_GAME, SEND_MESSAGE, //ロビーパネルコマンド
}
