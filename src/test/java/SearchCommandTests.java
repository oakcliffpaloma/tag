import org.improving.tag.commands.LookCommand;
import org.improving.tag.commands.SearchCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchCommandTests {

    SearchCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SearchCommand(io);
    }

    @Test
    public void execute_should_return_phrase(){
        //Act
        target.execute(null);

        //Assert
        assertEquals("You found a treasure", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_search() {
        //Act
        var result = target.isValid("search");

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
    public void isValid_should_be_true_when_input_is_search_with_spaces() {
        //Act
        var result = target.isValid("  search ");

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_search_with_caps() {
        //Act
        var result = target.isValid("SEArch");

        //Assert
        assertTrue(result);
    }
}
