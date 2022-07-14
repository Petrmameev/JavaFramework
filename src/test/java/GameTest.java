import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player p1 = new Player(11, "Вася", 4);
    Player p2 = new Player(12, "Шаокан", 99);
    Player p3 = new Player(13, "Ли", 10001);
    Player p4 = new Player(14, "Голберг", 4);
    Player p5 = new Player(15, "Рэмбо", 1345322);

    @Test
    public void shouldNotGameIfTwoPlayersNotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("unknown1", "unknown2");
        });
    }

    @Test
    public void shouldNotGameIfFirstPlayersNotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("unknown2", p5.getName());
        });
    }

    @Test
    public void shouldNotGameIfSecondPlayersNotRegistered() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round(p3.getName(), "unknown2");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        int actual = game.round(p5.getName(), p4.getName());
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        int actual = game.round(p2.getName(), p5.getName());
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        int actual = game.round(p1.getName(), p4.getName());
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("unknown1", "unknown2");
        });
    }

}
