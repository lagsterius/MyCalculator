grammar Calc;

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
    locals
    [
        Stack<BigDecimal> stack = new Stack<>()
    ]
	: mult (sign=(PLUS|MINUS) mult
	    {
            BigDecimal first = $str::stack.pop();
            BigDecimal second = $str::stack.pop();

            if ($sign.text.toString().equals("+"))
                $str::stack.push(second.add(first));
            else
                $str::stack.push(second.subtract(first));
        })* NEWLINE?
        {
            //System.out.println(" = " + $str::stack.pop());
        }
	;

parens
	: mult (sign=(PLUS|MINUS) mult
	    {
            BigDecimal first = $str::stack.pop();
            BigDecimal second = $str::stack.pop();

            if ($sign.text.toString().equals("+"))
                $str::stack.push(second.add(first));
            else
                $str::stack.push(second.subtract(first));
        })* NEWLINE?
	;

mult
	: pow (sign=(MULTIPLE|DIVISION|MOD) pow
	    {
            BigDecimal first = $str::stack.pop();
            BigDecimal second = $str::stack.pop();

            if ($sign.text.toString().equals("*"))
                $str::stack.push(second.multiply(first));
            else if ($sign.text.toString().equals("/"))
                $str::stack.push(second.divide(first, 20, RoundingMode.HALF_UP));
            else
                $str::stack.push(MyBigDecimalMath.mod(second, first));
        })*
	;

pow
	: atom (POW atom
	    {
            BigDecimal first = $str::stack.pop();
            BigDecimal second = $str::stack.pop();

	        //$str::stack.push(BigDecimalMath.powRound(second, first.toBigInteger()).setScale(5));
	        $str::stack.push(second.pow(first.intValue()));
	    })*
	;

atom
	: MINUS? NUMBER
	    {
	        BigDecimal value = new BigDecimal($NUMBER.text.toString());
	        if ($MINUS.text != null)
	            value = value.negate();
            $str::stack.push(value);
	    }
	| MINUS? funcname? LPAREN parens RPAREN
	    {
            if ($funcname.text != null)
                $str::stack.push(BigDecimalMath.sqrt($str::stack.pop()));
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