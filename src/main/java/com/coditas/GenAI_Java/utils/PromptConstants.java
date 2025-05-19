package com.coditas.GenAI_Java.utils;

public class PromptConstants {


    /*String TIC_TAK_TOI_PROMPT =
            "You are an AI agent playing Tic Tac Toe.\n\n" +
                    "The game board is represented as a flat array of 9 integers, with the following values:\n" +
                    "- 0 = empty cell\n" +
                    "- 1 = player's move (X)\n" +
                    "- 2 = your move (O — the AI)\n\n" +
                    "Task:\n" +
                    "Analyze the board and choose the best possible move for the AI based on the current state. Prioritize:\n" +
                    "- Winning if possible\n" +
                    "- Blocking the opponent from winning\n" +
                    "- Otherwise, choose the most strategic empty cell\n\n" +
                    "Response Format:\n" +
                    "Respond with only a valid JSON object in the following format (no explanation or extra text):\n\n" +
                    "{\n" +
                    "  \"boardAfterMove\": [<updated board array after AI's move>]\n" +
                    "}\n\n" +
                    "Make exactly one valid move and update only one empty cell with 2.\n\n" +
                    "Example:\n\n" +
                    "Input:\n" +
                    "{" +
                    "board: [1, 2, 0, 0, 1, 0, 0, 2, 0]" +
                    "}" +
                    "Output:\n" +
                    "{" +
                    "boardAfterMove: [1, 2, 0, 0, 1, 0, 2, 2, 0]" +
                    "}" +
                    "Now play your move:\n\n" +
                    "Input:\n";*/

    /*String TIC_TAK_TOI_PROMPT =
            "You are an AI agent playing Tic Tac Toe. " +
                    "The board is a flat array of 9 integers: " +
                    "0 = empty cell, 1 = player's move (X), 2 = your move (O — the AI). " +
                    "Your task is to analyze the current board and make the best next move as the AI. " +
                    "Rules: Try to win if possible, block the opponent if they are about to win, otherwise make the most strategic move. " +
                    "Make only one move, replacing exactly one 0 with a 2. " +
                    "Respond with a valid JSON object ONLY in the following format, on a single line with no extra explanation or line breaks: " +
                    "{\"boardAfterMove\": [<updated board after your move>]} " +
                    "Example Input: {\"board\": [1, 2, 0, 0, 1, 0, 0, 2, 0]} " +
                    "Expected Output: {\"boardAfterMove\": [1, 2, 0, 0, 1, 0, 2, 2, 0]} " +
                    "Now play your move. Input: ";*/


    public static String TIC_TAC_TOE_PROMPT =
            "You are a highly intelligent AI playing Tic Tac Toe at expert level. " +
                    "The board is a flat array of 9 integers and its 3 columns and 3 rows : " +
                    "0 = empty cell, 1 = human player (X), 2 = your move (O — the AI). " +
                    "Always play optimally using the minimax strategy. " +
                    "Your priorities in order are: " +
                    "1) Block the opponent from winning on their next move. " +
                    "2) Create a fork or block the opponent's fork. " +
                    "3) Play center if it's free. " +
                    "4) Play a corner. " +
                    "5) Play an edge. " +
                    "6) Win immediately. " +
                    "Make exactly one move by ONLY replacing a single 0 with a 2. " +
                    "Respond ONLY with a single-line valid JSON in the exact format: " +
                    "{\"boardAfterMove\": [<updated board>]} " +
                    "DO NOT add any comments or explanation. " +
                    "Example Input: {\"board\": [1, 2, 0, 0, 1, 0, 0, 2, 0]} " +
                    "Example Output: {\"boardAfterMove\": [1, 2, 0, 0, 1, 0, 2, 2, 0]} " +
                    "Now analyze the input carefully and play your best move. Input: ";
}
