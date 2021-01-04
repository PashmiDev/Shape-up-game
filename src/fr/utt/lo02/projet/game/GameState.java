package fr.utt.lo02.projet.game;

public enum GameState
{
    MOVE,
    PLACE,
    PLACE_DONE,
    MOVE_DONE,
    ACTION_FAILED,

    FIRST_TURN,

    FIRST_CHOICE,
    SECOND_CHOICE,

    END_TURN,
    CARD_DRAW,
    VICTORY_CARD,
    END_ROUND,
    END_GAME
}
