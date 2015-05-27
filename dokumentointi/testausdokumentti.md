
...tarkentuu myöhemmin...

JUnit testaus: pelilogiikka ja käyttöliittymään liittymättömät luokat
com.ued1.punaisenpaholaisenmetsastys.hahmot.*
com.ued1.punaisenpaholaisenmetsastys.logiikka.*

Käsintestaus: gui.logiikka
com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.*
com.ued1.punaisenpaholaisenmetsastys.gui.TarinaOsa.java
com.ued1.punaisenpaholaisenmetsastys.gui.KomentoOsa.java

com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanLataaja.java

Luokka lataa ohjelman tarvitsemia kuvia resource/kuvat hakemistosta ja tallentaa niitä KuvanAsettajalle annettavaan Map-olioon.

Luokkaa on testattu kokeilemalla yhdessä KuvanAsettajan kanssa. Ohjelma on rakennettu niin että kuvien puuttuessa kyseiset kuvat korvataan tekstillä.

com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KuvanAsettaja.java

Luokka asettaa KuvanLataajalta saamia BufferedImage-olioita JLabel-olioiden ikoneiksi. Mikäli ohjelma ei pysty lataamaan tai ei löydä haluttua kuvaa, asetetaan JLabel-olioon ikonin sijaan kuvaus. Mikäli kuvan asettaminen onnistuu, asetetaan kuvaus ToolTip-tekstiksi.

Luokkaa on testattu kokeilemalla siten, että aluksi kuvien nimet tai polut on annettu tahalteen väärin. Kun kuvan nimi tai polku on tahalteen kirjoitettu väärin, piirtyy kyseinen JLabel-olio ilman ikonia, sisältäen pelkästään ikonin kuvauksen JLabelin tekstinä.

com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonValidoija.java
com.ued1.punaisenpaholaisenmetsastys.gui.logiikka.KomennonKasittelija.java
com.ued1.punaisenpaholaisenmetsastys.gui.TarinaOsa.java
com.ued1.punaisenpaholaisenmetsastys.gui.KomentoOsa.java

Ylläolevia luokkia on testattu pelaamalla pelia ja kokeilemalla jokaisen lisäyksen jälkeen, että määritellyn napin painaminen johtaa haluttuun toimintoon. Kaikkia virheitä ei ole vielä korjattu, mutta virheet on kirjattu ylös ja odottavat korjaamista. Näiden luokkien osalla manuaalinen testaus jatkuu ohjelman valmistumiseen saakka.

