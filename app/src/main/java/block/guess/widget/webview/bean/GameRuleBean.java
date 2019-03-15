package block.guess.widget.webview.bean;

public class GameRuleBean {

    /**
     * id : 0
     * content : <p>BCH3D refers to a single bet with three numbers arranged or combined as a bet. The betting number is a number&nbsp;ranging from 000 to 999,&nbsp;the three positions from left to right are respectively "hundreds", "tens" and "uints", and the arrangement or combination of a group of three numbers is called a bet. The amount per bet is 0.0005BCH. The buyers may make multiple bets on their selected betting numbers in a range of 1-100 times. The maximum amount of a single bet shall not exceed 1.5 BCH.</p><p><br></p><p>The buyer can choose the machine selected number and the optional number to bet. The machine selected number betting refers to the betting number generated randomly to bet and the optional number betting means the betting number selected by the buyer to bet. 3D is sold in one phase every four hours and the serial number&nbsp;will increase itself as time goes on.</p><p><br></p><p>Set an award</p><p>BCH3D draws awards, platform operations and platform funds at 80%, 19%&nbsp;and 1% of current sales respectively.</p><p>The awarding rule is as follows:&nbsp;</p><p>	the single bet award is 200 times of the single bet price, namely, 0.1 BCH.</p><p>The Award Pool Fund consists of the difference between the accrual award and the actual award in the current phase. When the actual award&nbsp;is less than the accrual award in the current phase, the balance will enter the award pool; when the actual award exceeds the accrual award, the balance shall be replenished by the Award Pool Fund. When the total amount in Award Pool Fund is insufficient, it will be replenished by the platform fund. When the platform fund is insufficient, it shall be replenished by the platform. When the Award Pool Fund reaches 20 BCHs, the excessive part can be transferred to the platform fund.</p><p><br></p><p>Drawing</p><p>3D will be automatically drawn&nbsp;every four hours, and the system will acquire three random numbers A through <a href="http://random.org/" target="_blank">random.org</a> as one of the factors for winning numbers in the current period and obtains the latest&nbsp;height C in the current BCH block.</p><p>After each betting is finished, the system will write A and C into the block transactions and open the factors of generating the winning number, the total sales of the current period as well as the winning situations of each betting mode and so on to the public.</p><p><br></p><p>Winning</p><p>In accordance with&nbsp;the 3D betting numbers selected by the buyers and the matching of the opening numbers in the current period to determine the corresponding winning qualification.&nbsp;</p><p>The specific provisions are as follows:&nbsp;</p><p><br></p><p>If the betting numbers and the current opening numbers in the current period are all the same(hundreds+tens+uints), it means wining the numbers.</p><p><br></p><p>Collect the awards</p><p>According to the winning information, the system will automatically enter the winning amounts into the winners’ BCH addresses.</p><p><br></p><p>Winning Results</p><p>At the end of the current bet, the system will record the height of the current bch and acquire sign and random through random.org. After the system acquires the next burst of bch, it will carries on the drawing.</p><p><br></p><p>If the random number 123 obtained by random.org is used as the factor A of&nbsp;the winning number, and the latest burst height 530956 by the end of the current contract is taken as C, and then 00000000000000000167a4e4948c490ec4a1d7329e6d06ab3949616564523259,&nbsp;which is the hash value through obtaining 530957 burst by the system, will be used as the factor B of the winning number. Thus, the factors A and B will calculate the winning number 321 through the Platform disclosure algorithm( <a href="https://github.com/blockguess/random" target="_blank">https://github.com/blockguess/random</a>).</p>
     * category : 0
     * unit : 0
     * expired : 0
     * max : 8
     * times : 200
     * locale : en
     */

    private int id;
    private String content;
    private int category;
    private int unit;
    private int expired;
    private int max;
    private int times;
    private String locale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
