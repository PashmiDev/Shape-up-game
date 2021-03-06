package fr.utt.lo02.projet.model.board;


import java.util.Objects;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * Represents a card from the Game
 * A card is made of a color, a shape and if its filled or not.
 *
 * @author Baptiste, Jacques
 */
public class Card
{

    /**
     * The color of the card can be red, green or blue
     */
    public enum Color
    {BLUE, GREEN, RED}

    /**
     * The shape of the card can be a triangle, a circle or a square
     */
    public enum Shape
    {CIRCLE, TRIANGLE, SQUARE}

    /**
     * A card can be filled or not (hollow).
     */
    public enum Filling
    {HOLLOW, FILLED}


    private final Color color;
    private final Shape shape;
    private final Filling filling;

    public Card(Color c, Shape s, Filling f)
    {
        this.color = c;
        this.shape = s;
        this.filling = f;

    }

    public Color getColor()
    {
        return color;
    }

    public Shape getShape()
    {
        return shape;
    }

    public Filling getFilling()
    {
        return filling;
    }

    /**
     * Print a card in terminal using ascii art
     * @param card the card to print
     */
    public static void printSingleCard(Card card)
    {
        if (card == null)
        {
            return;
        }
        printTop(card.getColor());
        System.out.println();
        printMiddle(card);
        System.out.println();
        printBottom(card.getColor());
        System.out.println();
    }

    /**
     * Print the bottom part of a card in terminal using ascii art
     * @param color the color of the card
     */
    public static void printBottom(Card.Color color)
    {
        switch (color)
        {
            case RED -> System.out.print(colorize("└─┘ ", RED_TEXT()));
            case BLUE -> System.out.print(colorize("└─┘ ", BLUE_TEXT()));
            case GREEN -> System.out.print(colorize("└─┘ ", GREEN_TEXT()));
        }
    }
    /**
     * Print the upper part of a card in terminal using ascii art
     * @param color the color of the card
     */
    public static void printTop(Card.Color color)
    {
        switch (color)
        {
            case RED -> System.out.print(colorize("┌─┐ ", RED_TEXT()));
            case BLUE -> System.out.print(colorize("┌─┐ ", BLUE_TEXT()));
            case GREEN -> System.out.print(colorize("┌─┐ ", GREEN_TEXT()));
        }

    }

    /**
     * Print the middle part of a card in terminal using ascii art
     * with the symbol, color and shape
     * @param card the card
     */
    public static void printMiddle(Card card)
    {
        StringBuilder buf = new StringBuilder();
        buf.append("│");
        switch (card.getShape())
        {
            case CIRCLE -> {
                if (card.getFilling() == Card.Filling.HOLLOW)
                {
                    buf.append("○");
                } else
                {
                    buf.append("●");
                }
            }
            case TRIANGLE -> {
                if (card.getFilling() == Card.Filling.HOLLOW)
                {
                    buf.append("▵");
                } else
                {
                    buf.append("▲");
                }
            }
            case SQUARE -> {
                if (card.getFilling() == Card.Filling.HOLLOW)
                {
                    buf.append("▫");
                } else
                {
                    buf.append("▪");
                }
            }
        }
        buf.append("│ ");
        switch (card.getColor())
        {
            case BLUE -> System.out.print(colorize(buf.toString(), BLUE_TEXT()));
            case GREEN -> System.out.print(colorize(buf.toString(), GREEN_TEXT()));
            case RED -> System.out.print(colorize(buf.toString(), RED_TEXT()));
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color &&
                shape == card.shape &&
                filling == card.filling;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(color, shape, filling);
    }

    @Override
    public String toString()
    {
        return "Card{" +
                "color=" + color +
                ", shape=" + shape +
                ", filling=" + filling +
                '}';
    }

}
