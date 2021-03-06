package com.wickedspiral.jacss.lexer.builder;

import com.wickedspiral.jacss.lexer.ParserState;
import com.wickedspiral.jacss.lexer.Token;
import com.wickedspiral.jacss.lexer.TokenBuilder;
import com.wickedspiral.jacss.lexer.UnrecognizedCharacterException;

/**
 * @author wasche
 * @since 2011.08.04
 */
public class CommentTokenBuilder implements TokenBuilder
{
    public void handle(ParserState state, char c) throws UnrecognizedCharacterException
    {
        if (state.getTokenLength() == 1 && c != '*')
        {
            // oops, not a comment, just a /
            state.tokenFinished(Token.OP)
                 .clearToken()
                 .unsetTokenBuilder()
                 .tokenize(c);
        }
        else if (c == '/' && state.getLastCharacter() == '*')
        {
            state.push(c)
                 .tokenFinished(Token.COMMENT)
                 .unsetTokenBuilder();
        }
        else
        {
            state.push(c);
        }
    }
}
