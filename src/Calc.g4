grammar Calc;

@members {
    BigDecimal first, second;
    Stack<BigDecimal> stack = new Stack<>();
    String result;
}

options
{
	language = Java;
}


@header {
    import java.util.Stack;
    import java.math.BigDecimal;
    import java.math.RoundingMode;
}

str
    : mult (sign=(PLUS|MINUS) mult
        {
            first = stack.pop();
            second = stack.pop();

            try {
                if ($sign.text.toString().equals("+"))
                    stack.push(second.add(first));
                else
                    stack.push(second.subtract(first));
            }
            catch (Exception e) {
               stack.push(BigDecimal.ZERO);
            }
        })* NEWLINE?
        {
            result = stack.pop().toString();
        }
    ;

parens
    : mult (sign=(PLUS|MINUS) mult
        {
            first = stack.pop();
            second = stack.pop();

            try {
                if ($sign.text.toString().equals("+"))
                    stack.push(second.add(first));
                else
                    stack.push(second.subtract(first));
            }
            catch (Exception e) {
               stack.push(BigDecimal.ZERO);
            }
        })*
    ;

mult
	: pow (sign=(MULTIPLE|DIVISION|MOD) pow
	    {
            first = stack.pop();
            second = stack.pop();

            try {
                if ($sign.text.toString().equals("*"))
                    stack.push(second.multiply(first));
                else if ($sign.text.toString().equals("/"))
                    stack.push(second.divide(first, 1, RoundingMode.CEILING));
                else
                    stack.push(MyBigDecimalMath.mod(second, first));
            }
            catch (Exception e) {
               stack.push(BigDecimal.ONE);
            }
        })*
	;

pow
	: atom (POW atom
	    {
            first = stack.pop();
            second = stack.pop();

	        try {
	            if (first.intValue() < 1000000 && first.intValue() > -1000000)
	                stack.push(second.pow(first.intValue()));
                else
                    stack.push(second);
            }
            catch (Exception e) {
                stack.push(BigDecimal.ZERO);
            }
	    })*
	;

atom
	: MINUS? NUMBER
	    {
	        BigDecimal value = new BigDecimal($NUMBER.text.toString());
	        if ($MINUS.text != null)
	            value = value.negate();
            stack.push(value);
	    }
	| MINUS? funcname? LPAREN parens RPAREN
	    {
            try {
                if ($funcname.text != null)
                    stack.push(MyBigDecimalMath.sqrt(stack.pop()));
            }
            catch (Exception e) {
                stack.push(BigDecimal.ONE);
            }
	    }
	;

funcname
    : SQRT
    ;

NUMBER
	: DIGIT* DOT? DIGIT+(E DIGIT+)?
	;

fragment
DIGIT
	: [0-9]
	;

WS
	: [ \t\r\n]+ -> channel(HIDDEN)
	;

NEWLINE
	: '\n'
	;

PLUS
	: '+'
	;

MINUS
	: '-'
	;

MULTIPLE
	: '*'
	;

DIVISION
	: '/';

MOD
	: '%'
	;

POW
	: '^'
	;

E
	: [Ee]
	;

LPAREN
	: '('
	;

RPAREN
	: ')'
	;

DOT
	: '.'
	;

SQRT
    : 'sqrt'
    ;