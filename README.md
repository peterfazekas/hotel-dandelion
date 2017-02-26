<h1>Pitypang - Hotel Dandelion</h1>
<h2>Informatika érettségi emelt szintű feladat: 2011. október</h2>
<p>A kerekdombi <b>Pitypang wellness hotel</b> nem régen nyitotta meg kapuit. A szállodában összesen 27 szoba van. A szobák egységesen kétágyasak, de minden szobában egy pótágy elhelyezésére is van lehetőség. Árképzés szempontjából három különböző időszakot határolt el a szálloda vezetősége: tavaszi, nyári és őszi szakaszt. Ennek megfelelően az árakat az alábbi táblázat tartalmazza.</p>
<table>
<tr><th>Tavasz</th><th>Nyár</th><th>Ősz</th></tr>
<tr><td align="center">01. 01. – 04. 30.</td><td align="center">05. 01. – 08. 31.</td><td align="center">05. 01. – 08. 31.</td></tr>
<tr><td align="center">9 000 Ft</td><td align="center">10 000 Ft</td><td align="center">8 000 Ft</td></tr>
</table>
<p>A feltüntetett értékek egy szoba árát mutatják egy éjszakára. Ha csak egy fő száll meg, akkor is ki kell fizetni a teljes szobaárat. Egy adott foglalás besorolása az érkezés napjától függ.</p>
<p>A pótágy díja 2 000 Ft éjszakánként. Amennyiben a vendég igényel reggelit, azért a fenti áron felül személyenként és naponként 1 100 Ft-ot kell fizetni.</p>
<p>Ha például a két felnőttből és egy gyermekből álló Tóth család április 30. és május 4. között 4 éjszakát tölt a hotelben és kér reggelit, akkor ők az alábbi összegeket fizetik:</p>
<ul>
<li>4 × 9 000 Ft-ot a szobáért,
<li>4 × 2 000 Ft-ot a pótágyért,
<li>4 × 3 × 1 100 Ft-ot a reggeliért.
</ul>
<p>A végső számla így 36 000 Ft + 8 000 Ft + 13 200 Ft = 57 200 Ft lesz.</p>
<p>A szálloda eddigi foglalásait a <i>pitypang.txt</i> fájl tartalmazza. Az első sor a fájlban tárolt foglalások számát mutatja. A további sorokban szóközzel elválasztva soronként az alábbi adatok találhatók:</p>
<ul>
<li>a foglalás sorszáma,
<li>a szoba száma (1–27),
<li>az érkezés napjának sorszáma,
<li>a távozás napjának sorszáma,
<li>a vendégek száma,
<li>kérnek-e reggelit (1=igen vagy 0=nem),
<li>a foglalást végző vendég nevéből képzett azonosítója (maximum 25 karakter).
</ul>
<p>A napok sorszámozása január 1-jétől (1-es sorszám) kezdődik. Április 30-hoz például a 31 + 28 + 31 + 30 = 120-as sorszám tartozik.</p>
<p>A Tóth család foglalása ebben a szerkezetben a következőképpen néz ki:</p>
<pre>123 21 120 124 3 1 Toth_Balint</pre>
<p>A fájl egy éven belül tartalmaz foglalásokat. Az adatok az érkezés napja szerint növekvő sorrendben vannak rendezve a fájlban.</p>
<p>Tájékoztatásul a <i>honapok.txt</i> fájl a hónapok neveit, a rá következő sorban az adott hónap napjainak számát, majd az ezt követő sorban pedig a hónap első napjának sorszámát tartalmazza. Az állományt forrásfájlként is felhasználhatja. A fenti táblázatnak megfelelő nyári időszak a 121. napon, míg az őszi a 244. napon kezdődik.</p>
<p>Készítsen programot <i>szalloda</i> néven, amely az alábbi kérdésekre válaszol!</p>
<p>A képernyőre írást igénylő részfeladatok eredményének megjelenítése előtt írja a képernyőre a feladat sorszámát (például <i>3. feladat:</i>)! Ahol a felhasználótól kér be adatot, ott írja a képernyőre, hogy milyen adatot vár!</p>
<ol>
<li>Olvassa be az <i>pitypang.txt</i> állományban található maximum 1 000 foglalás adatát, s annak felhasználásával oldja meg a következő feladatokat! Ha az állományt nem tudja beolvasni, akkor a benne található adatok közül az 1-5, 326-330 és 695-699 foglalási sorszámú sorok adatait jegyezze be a programba, s úgy oldja meg a feladatokat!</li>
<li>Jelenítse meg a képernyőn a leghosszabb szállodai tartózkodást! Csak az időtartamot vegye figyelembe, azaz nem számít, hogy hány vendég lakott az adott szobában! Az esetlegesen azonos hosszúságú tartózkodások közül bármelyiket kiválaszthatja. Az eredményt ebben a formában írja a képernyőre:
<p><i>Név (érkezési_nap_sorszáma) – eltöltött_éjszakák_száma</i></p>
<pre>például: Nagy_Bertalan (105) – 16</pre></li>
<li>Számítsa ki, hogy az egyes foglalások után mennyit kell fizetnie az egyes vendégeknek! A foglalás sorszámát és a kiszámított értékeket kettősponttal elválasztva írja ki a <i>bevetel.txt</i> fájlba!
<p>Ez – a példában szereplő Tóth család esetén – a következő lenne:</p>
<pre>123:57200</pre>
<p><i>(Amennyiben nem tudja a fájlba íratni a kiszámított értékeket,     úgy az első tíz foglaláshoz tartozó értéket a képernyőre írassa ki!)</i></p>
<p>Írja a képernyőre a szálloda teljes évi bevételét!</p></li>
<li>Készítsen statisztikát az egyes hónapokban eltöltött vendégéjszakákról! Egy vendégéjszakának egy fő egy eltöltött éjszakája számít. A példában szereplő Tóth család áprilisban 3, májusban pedig 9 vendégéjszakát töltött a szállodában. Írassa ki a havi vendégéjszakák számát a képernyőre az alábbi formában:
<p><i>hónap_sorszáma: x vendégéj</i></p>
<pre>például: 8: 1059 vendégéj</pre></li>
<li>Kérje be a felhasználótól egy új foglalás kezdő dátumához tartozó nap sorszámát és az eltöltendő éjszakák számát! Határozza meg, hogy hány szoba szabad a megadott időszak teljes időtartamában! A választ írassa ki a képernyőre!</li>
</ol>
<hr>
<h3>Források</h3>
<ul>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok2011osz/emelt/e_inf_11okt_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok2011osz/emelt/e_inffor_11okt_fl.zip">Forrásállományok</a>
</ul>