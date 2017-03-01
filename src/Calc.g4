grammar Calc;

@members {
    Stack<BigDecimal> stack = new Stack<>();
}

options
{
	language = Java;
}


@header {
    import java.util.Stack;
    import org.nevec.rjm.*;
    import java.math.BigDecimal;
    import java.math.RoundingMode;
}

str
     	: mult (sign=(PLUS|MINUS) mult
     	    {
                 BigDecimal first = stack.pop();
                 BigDecimal second = stack.pop();

                 if ($sign.text.toString().equals("+"))
                     stack.push(second.add(first));
                 else
                     stack.push(second.subtract(first));
             })* NEWLINE?
             {
                 System.out.println(" = " + stack.pop());
             }
     	;

parens
    : mult (sign=(PLUS|MINUS) mult
        {
            BigDecimal first = stack.pop();
            BigDecimal second = stack.pop();

            if ($sign.text.toString().equals("+"))
                stack.push(second.add(first));
            else
                stack.push(second.subtract(first));
        })*
    ;

mult
	: pow (sign=(MULTIPLE|DIVISION|MOD) pow
	    {
            BigDecimal first = stack.pop();
            BigDecimal second = stack.pop();

            if ($sign.text.toString().equals("*"))
                stack.push(second.multiply(first));
            else if ($sign.text.toString().equals("/"))
                stack.push(second.divide(first, 1, RoundingMode.CEILING));
            else
                stack.push(MyBigDecimalMath.mod(second, first));
        })*
	;

pow
	: atom (POW atom
	    {
            BigDecimal first = stack.pop();
            BigDecimal second = stack.pop();

	        stack.push(second.pow(first.intValue()));
	    })*
	;

atom
	: MINUS? NUMBER
	    {
	        BigDecimal value = new BigDecimal($NUMBER.text.toString());
	        if ($MINUS.text != null)
	            value = value.negate();
            stack.push(value);
            //System.out.println(value);
	    }
	| MINUS? funcname? LPAREN parens RPAREN
	    {
            if ($funcname.text != null)
                stack.push(BigDecimalMath.sqrt(stack.pop()));
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
	: [ \t\r]+ -> skip
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