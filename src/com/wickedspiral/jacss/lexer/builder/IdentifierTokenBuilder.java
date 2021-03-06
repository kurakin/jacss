package com.wickedspiral.jacss.lexer.builder;

import com.wickedspiral.jacss.lexer.ParserState;
import com.wickedspiral.jacss.lexer.Token;
import com.wickedspiral.jacss.lexer.TokenBuilder;
import com.wickedspiral.jacss.lexer.UnrecognizedCharacterException;

/**
 * @author wasche
 * @since 2011.08.04
 */
public class IdentifierTokenBuilder implements TokenBuilder
{
    public void handle(ParserState state, char c) throws UnrecognizedCharacterException
    {
        if (Character.isLetterOrDigit(c) || c == '_' || c == '-')
        {
            state.push(c);
        }
        else
        {
            state.tokenFinished(Token.IDENTIFIER)
                 .unsetTokenBuilder()
                 .tokenize(c);
        }
    }
}
