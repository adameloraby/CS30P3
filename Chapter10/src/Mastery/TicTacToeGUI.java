package Mastery;

import java.awt.*;
import javax.swing.*;

public class TicTacToeGUI {

    private JFrame frame;
    private JButton[][] buttons;
    private JLabel status;
    private TTT game;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TicTacToeGUI window = new TicTacToeGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TicTacToeGUI() {
        game = new TTT();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Tic Tac Toe");
        frame.setBounds(100, 100, 400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        buttons = new JButton[3][3];
        Font btnFont = new Font("Arial", Font.BOLD, 48);

        int size = 100;   // button width/height
        int offsetX = 50; // left margin
        int offsetY = 50; // top margin

        // Place 9 buttons in a grid manually
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(btnFont);
                buttons[i][j].setFocusPainted(false);

                int row = i, col = j;
                buttons[i][j].setBounds(offsetX + j * size,
                                        offsetY + i * size,
                                        size, size);

                buttons[i][j].addActionListener(e -> handleMove(row, col));
                frame.getContentPane().add(buttons[i][j]);
            }
        }

        // Status label under the board
        status = new JLabel("Player X's turn");
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setFont(new Font("Arial", Font.PLAIN, 20));
        status.setBounds(50, 360, 300, 30);
        frame.getContentPane().add(status);
    }

    private void handleMove(int row, int col) {
        if (game.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
            char winner = game.checkWinner();

            if (winner == 'X' || winner == 'O') {
                JOptionPane.showMessageDialog(frame,
                        "Player " + winner + " wins!");
                resetGame();
            } else if (winner == 'T') {
                JOptionPane.showMessageDialog(frame,
                        "It's a tie!");
                resetGame();
            } else {
                game.switchPlayer();
                status.setText("Player " + game.getCurrentPlayer() + "'s turn");
            }
        }
    }

    private void resetGame() {
        game.reset();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        status.setText("Player X's turn");
    }
}

// ----------------------------------------------------
// Inner game logic class (non-public)
// ----------------------------------------------------
class TTT {
    private char[][] board;
    private char currentPlayer;

    public TTT() {
        board = new char[3][3];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char checkWinner() {
        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // cols
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // diagonals
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return board[0][2];
        }

        // tie check
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                }
            }
        }
        if (full) return 'T'; // tie

        return ' '; // no winner yet
    }
}