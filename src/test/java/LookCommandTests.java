import org.improving.tag.commands.LookCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LookCommandTests {
    LookCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new LookCommand(io);
    }

    @Test
    public void execute_should_return_phrase(){
        //Act
        target.execute(null);

        //Assert
        assertEquals("You look around", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_look() {
        //Act
        var result = target.isValid("look");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_foobar() {
        //Act
        var result = target.isValid("foobar");

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid( null);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_look_with_spaces() {
        //Act
        var result = target.isValid("  look ");

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_look_with_caps() {
        //Act
        var result = target.isValid("Look");

        //Assert
        assertTrue(result);
    }
}
