import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private JLabel[] scoreLabels;
    private char[][] board;
    private char currentPlayer;
    private int xWins, oWins, ties;

    public TicTacToe() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';

        Font buttonFont = new Font("Arial", Font.BOLD, 50);
        Font scoreFont = new Font("Arial", Font.PLAIN, 20);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(buttonFont);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                buttons[i][j].setFocusPainted(false);
                boardPanel.add(buttons[i][j]);
            }
        }

        resetBoard();

        add(boardPanel, BorderLayout.CENTER);

        JPanel scorePanel = new JPanel(new GridLayout(1, 3));
        scoreLabels = new JLabel[3];
        scoreLabels[0] = new JLabel("X Wins: 0");
        scoreLabels[1] = new JLabel("O Wins: 0");
        scoreLabels[2] = new JLabel("Ties: 0");

        for (int i = 0; i < 3; i++) {
            scoreLabels[i].setFont(scoreFont);
            scoreLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            scoreLabels[i].setBackground(Color.LIGHT_GRAY);
            scoreLabels[i].setOpaque(true);
            scoreLabels[i].setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            scorePanel.add(scoreLabels[i]);
        }

        JPanel scoreboardPanel = new JPanel(new BorderLayout());
        scoreboardPanel.setPreferredSize(new Dimension(500, 80));
        scoreboardPanel.setBackground(Color.LIGHT_GRAY);
        scoreboardPanel.add(scorePanel, BorderLayout.CENTER);
        add(scoreboardPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void resetBoard() {
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                board[i][j] = '-';
            }
        }
    }

    private void updateScoreboard() {
        scoreLabels[0].setText("X Wins: " + xWins);
        scoreLabels[1].setText("O Wins: " + oWins);
        scoreLabels[2].setText("Ties: " + ties);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));

            int row = -1, col = -1;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j] == button) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }

            if (row != -1 && col != -1) {
                board[row][col] = currentPlayer;
                button.setForeground(currentPlayer == 'X' ? Color.RED : Color.BLUE);
                button.setEnabled(false);

                checkWinCondition();

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private void checkWinCondition() {
        char[] players = { 'X', 'O' };
        boolean winnerFound = false;

        for (char player : players) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    handleWin(player);
                    winnerFound = true;
                    break;
                }
            }

            for (int j = 0; j < 3; j++) {
                if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                    handleWin(player);
                    winnerFound = true;
                    break;
                }
            }

            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                handleWin(player);
                winnerFound = true;
                break;
            }

            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                handleWin(player);
                winnerFound = true;
                break;
            }
        }

        if (!winnerFound && isBoardFull()) {
            ties++;
            updateScoreboard();
            JOptionPane.showMessageDialog(this, "It's a tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetBoard();
        }
    }

    private void handleWin(char player) {
        if (player == 'X') {
            xWins++;
        } else {
            oWins++;
        }

        updateScoreboard();
        String message = "<html><font color='" + (player == 'X' ? "red" : "blue") + "'>Player " + player
                + " wins!</font></html>";
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        resetBoard();
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
