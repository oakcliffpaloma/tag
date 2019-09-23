import org.improving.tag.Game;
import org.improving.tag.commands.MoveCommand;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetNameCommandTests {
    SetNameCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
        game = new Game(null, io);
    }

    @Test
    public void execute_should_display_all_words_but_setname() {
        //Act
        target.execute("@Set name=Paloma", game);

        //Assert
        assertEquals("Your name is now Paloma", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_setname_with_spaces() {
        //Act
        target.execute("   @set name=Paloma ", game);

        //Assert
        assertEquals("Your name is now Paloma", io.lastText);

    }
    @Test
    public void isValid_should_be_true_when_input_is_move() {
        //Act
        var result = target.isValid("@set name= Paloma", null);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_foobar() {
        //Act
        var result = target.isValid("foobar", null);

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid( null, null);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move_with_spaces() {
        //Act
        var result = target.isValid("  @set name= Paloma ", null);

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_move_with_caps() {
        //Act
        var result = target.isValid("@SET name= PALOMA", null);

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        //Act
        var result = target.isValid("name", null);

        //Assert
        assertFalse(result);
    }
}
