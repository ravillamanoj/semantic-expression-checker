package com.mr.semantic.expresion.checker;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 * Parses and evaluates the mathematical expressions.
 *
 * @author Manoj
 */
public class ExpressionParser {
    private final String input;

    public ExpressionParser(String input) {
        this.input = input;
    }

    public String evaluateExpression() throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String ret = engine.eval(input).toString().toUpperCase();
        return ret;
    }
}