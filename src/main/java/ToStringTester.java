//usr/bin/env jbang "$0" "$@" ; exit $?

import com.github.jtama.crazy.dop.Color;
import com.github.jtama.crazy.dop.GrohlOMeter;
import com.github.jtama.crazy.dop.SuitCard;
import com.github.jtama.crazy.dop.TrumpCard;


void main() {
    System.out.println(new SuitCard(Color.SPADES, 10, null));
    System.out.println(new TrumpCard(21));
    System.out.println(GrohlOMeter.onTheGrohlScale(new TrumpCard(21)));
}