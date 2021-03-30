package come.videoslots.machine.utils;

import come.videoslots.machine.dto.Symbol;
import come.videoslots.machine.protocol.SlotActionRequest;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BoardGenerator {

    private final static Random random = new Random();
    private final static List<String> symbols = Arrays.asList("9", "10", "J", "Q", "K", "A", "cat", "dog", "mon", "bir");

    private static final int rowCount = 3;
    private static final int columnCount = 5;

    public List<Symbol> generateBoard(SlotActionRequest request) {
        if (request.getCheatCodes() != null && !request.getCheatCodes().isEmpty()) {
            return generateCheatBoard(request.getCheatCodes());
        }

        return generateRandomBoard();
    }

    public List<Symbol> generateRandomBoard() {
        int index = 0;
        List<Symbol> board = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                board.add(new Symbol(index, i + (j * rowCount), symbols.get(random.nextInt(10))));
                index++;
            }
        }
        return board;
    }

    public List<Symbol> generateCheatBoard(Map<String, String> cheatCodes) {
        int index = 0;
        List<Symbol> board = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int pos = i + (j * rowCount);
                String name = cheatCodes.get(Integer.toString(pos)) != null ? cheatCodes.get(Integer.toString(pos)) : symbols.get(random.nextInt(10));
                board.add(new Symbol(index, pos, name));
                index++;
            }
        }
        return board;
    }


    public Map<Integer, Symbol> flatBoard(List<Symbol> board) {
        Map<Integer, Symbol> flatBoard = new HashMap<>();
        board.forEach(b -> flatBoard.put(b.getPos(), b));
        return flatBoard;
    }
}
