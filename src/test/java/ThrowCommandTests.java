import org.improving.tag.commands.LookCommand;
import org.improving.tag.commands.ThrowCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThrowCommandTests {

    ThrowCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new ThrowCommand(io);
    }

    @Test
    public void execute_should_return_phrase(){
        //Act
        target.execute(null, null);

        //Assert
        assertEquals("You threw it far", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_look() {
        //Act
        var result = target.isValid("throw", null);

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
    public void isValid_should_be_true_when_input_is_throw_with_spaces() {
        //Act
        var result = target.isValid("  throw ", null);

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_throw_with_caps() {
        //Act
        var result = target.isValid("THRow", null);

        //Assert
        assertTrue(result);
    }}
