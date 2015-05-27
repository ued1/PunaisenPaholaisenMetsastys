Kuvilla höystetty dynaaminen tekstipohjainen rooli/seikkailupeli, jossa tavoitteena on etsiä ja tappaa kylääsi piinaava Punainen Paholainen. Tarina etenee tekstimuodossa, mutta käyttöliittymä ja toiminnot ovat graafisessa muodossa.

Kylää ympäröivässä metsässä on monstereita, joita vastaan taistelemalla ansaitsee kultarahoja. Kultarahoilla voi ostaa parempia aseita ja haarniskoja, joiden avulla voi haastaa kilpailevia taistelijoita ja edetä seuraavalle tasolle. Kun on tarpeeksi korkealla tasolla, voi lopulta etsia ja haastaa Punaisen Paholaisen.

Kylän asepajassa voi ostaa parempia aseita.
- Aseen ostaminen: uuden aseen voi ostaa, mikäli pelaajalla on tarpeeksi rahaa ja hän on ensin myynyt vanhan aseensa
- Aseen myyminen: aseen myydessä puolet sen arvosta palautetaan kultarahoina takaisin. Omaa nyrkkiä, mikä on aloitusase, ei kuitenkaan voi myydä.

Haarniskakaupassa voi ostaa parempaa suojausta itselleen
- Haarniskan ostaminen: kuten asekaupassa, mutta vanhaa haarniskaa ei myydä (emme vahingossakaan halua kylään alastomia sotureita). Vanhasta haarniskasta ei myöskään palauteta rahaa kuten aseen tapauksessa.

Taisteluareenalla voi kehittää omaa osaamistaan.
- Haastetaan kilpailijoita (pelin hahmoja, jotka kilpailevat kanssasi siitä, kuka tappaa Punaisen Paholaisen ensimmäisenä. Kilpailijat eivät oikeasti kuitenkaan koskaan tule haastamaan Punaista Paholaista) taisteluun. Tarpeeksi voittopisteitä kerättyään nousee seuraavalle tasolle, jolloin metsästä löytyy kovempia ja rahakkaampia monstereita (rahalla saa parempia varusteita, joilla puolestaan on mahdollista nousta seuraavalla tasolle, jne.).
- Kilpailijoita tulee jokaisella tasolla vastaan (taso+1) kappaletta. He ovat huomattavasti monstereite vahvempia, mutta yrittää voi kuinka monta kertaa tahansa.

Metsässä taistellaan monstereita vastaan ja ansaitaan rahaa parempia varusteita varten
- Etsimällä monsteria peli generoi sopivan tasoisen monsterin taisteluun. Monsterin vaikeus määräytyy pelaajan tason, lyontivoiman ja suojausvoiman perusteella. Voittamalla monsterin pelaajalla on enemmän kultarahoja käytettävissään, häviämällä menettää kaikki rahat. Useimmat monstereista ovat voitettavissa, loppujen kanssa tulee osata juosta karkuun välttääkseen kuoleman ja pelin loppumisen. Monsterien nimet arvotaan sattumanvaraisesti, mikään nimi ei ole sidoksissa tietyn tasoiseen monsteriin.
 
Taistelut tapahtuvat hahmojen välillä joko metsässä (monsterit), taisteluareenalla (kilpailijat) tai luolassa (Punainen Paholainen). Pelaaja lyö aina ensin, sen jälkeen vastustaja. Metsässä ollessaan pelaaja voi päättää jatkaako taistelua vai juokseeko karkuun. Taisteluareenalla ja Punaista Paholaista vastaan taistellessa juokseminen ei ole mahdollista. Taistelun hävitessä pelaaja menettää rahansa. Voittaessa pelaaja saa rahaa (taistelut monstereita vastaan) tai pelaajan ominaisuudet paranevat (taistelut kilpailijoita vastaan).

Paholaisen Luola aktivoituu metsässä pelin lopussa, kun on noussut tarpeeksi korkealle tasolle.
- Pelaaja voi halutessaan haastaa Punaisen Paholaisen ja pelastaa kylän (pelin voitto), mutta hänellä on vain yksi mahdollisuus. Hävitettään taistelun peli loppuu tappioon.

Hahmojen ominaisuuksia ovat vointi, voima, puolustus, taso ja kokemus. Vointi määräytyy pelaajan tason mukaan; mitä korkeampi taso sitä parempi vointi. Voinnin laskiessa nollaan pelaaja menettää rahansa. Vointia voi paranpaa lepäämällä milloin tahansa kunhan ei ole taistelu käynnissä. Voima määräytyy pelaajan aseen mukaan. Mitä suurempi lyöntivoima, sitä enemmän vahinkoa on mahdollista tehdä vastustajaan. Lyöntivoima on random-luku väliltä (puoletLyontiVoima..maxLyontiVoima). Vastustaja voi kuitenkin puolustautua ennen kuin lyönti osuu. Puolustusvoima määräytyy suoraan haarniskan mukaan. Lyojän lyöntivoimasta vähennetään puolustajan puolustusvoima ja tämä (epänegatiivinen) erotus laskee vointia. Vastustaja ei osu, mikäli pelaajan puolustus on suurempi kuin vastustajan lyöntivoima. Pelaaja puolestaan osu aina, vastustajan vointi laskee vähintään yhdellä.
