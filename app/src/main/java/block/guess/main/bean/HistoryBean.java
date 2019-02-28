package block.guess.main.bean;

import java.io.Serializable;
import java.util.List;

public class HistoryBean implements Serializable{


    /**
     * txid : ecd7e87f9f5312425aa85965e2df90a5e8ada8fedeb66c977f342b2c61bcce5e
     * version : 1
     * locktime : 0
     * isCoinBase : false
     * vin : [{"txid":"a84c09fc2485ccece386f6cc73d7b75ca632c73d3bc326766b042dcdb3cb503d","vout":2,"addr":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","value":0.82291248,"valueSat":82291248}]
     * vout : [{"value":"0.00400000","scriptPubKey":{"addresses":["19ph8L92Q1uUKUNExksgGYRXrGMaD1daXW"]}},{"value":"0.00000000","scriptPubKey":{"addresses":null}},{"value":"0.81890883","scriptPubKey":{"addresses":["1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h"]}}]
     * blockhash : 000000000000000001438319134f82c0c48bd8f8e90000520873724ee735b3d3
     * confirmations : 433
     * time : 1535793819
     * blocktime : 1535793819
     * created_at : 1535793819
     * valueOut : 0.82290883
     * valueIn : 0.82291248
     * fees : 3.65E-6
     * size : 316
     * op_category : {"category":8}
     * balance_diff : -400365
     */
    private String txid;
    private int version;
    private int locktime;
    private boolean isCoinBase;
    private String blockhash;
    private int confirmations;
    private long time;
    private int blocktime;
    private int created_at;
    private double valueOut;
    private double valueIn;
    private double fees;
    private int size;
    private OpCategoryBean op_category;
    private long balance_diff;
    private List<VinBean> vin;
    private List<VoutBean> vout;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLocktime() {
        return locktime;
    }

    public void setLocktime(int locktime) {
        this.locktime = locktime;
    }

    public boolean isIsCoinBase() {
        return isCoinBase;
    }

    public void setIsCoinBase(boolean isCoinBase) {
        this.isCoinBase = isCoinBase;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(int blocktime) {
        this.blocktime = blocktime;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public double getValueOut() {
        return valueOut;
    }

    public void setValueOut(double valueOut) {
        this.valueOut = valueOut;
    }

    public double getValueIn() {
        return valueIn;
    }

    public void setValueIn(double valueIn) {
        this.valueIn = valueIn;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public OpCategoryBean getOp_category() {
        return op_category;
    }

    public void setOp_category(OpCategoryBean op_category) {
        this.op_category = op_category;
    }

    public long getBalance_diff() {
        return balance_diff;
    }

    public void setBalance_diff(long balance_diff) {
        this.balance_diff = balance_diff;
    }

    public List<VinBean> getVin() {
        return vin;
    }

    public void setVin(List<VinBean> vin) {
        this.vin = vin;
    }

    public List<VoutBean> getVout() {
        return vout;
    }

    public void setVout(List<VoutBean> vout) {
        this.vout = vout;
    }

    public static class OpCategoryBean implements Serializable{
        /**
         * category : 8
         */

        private int category;

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class VinBean implements Serializable{
        /**
         * txid : a84c09fc2485ccece386f6cc73d7b75ca632c73d3bc326766b042dcdb3cb503d
         * vout : 2
         * addr : 1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h
         * value : 0.82291248
         * valueSat : 82291248
         */

        private String txid;
        private int vout;
        private String addr;
        private double value;
        private int valueSat;

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public int getVout() {
            return vout;
        }

        public void setVout(int vout) {
            this.vout = vout;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public int getValueSat() {
            return valueSat;
        }

        public void setValueSat(int valueSat) {
            this.valueSat = valueSat;
        }
    }

    public static class VoutBean implements Serializable{
        /**
         * value : 0.00400000
         * scriptPubKey : {"addresses":["19ph8L92Q1uUKUNExksgGYRXrGMaD1daXW"]}
         */

        private String value;
        private ScriptPubKeyBean scriptPubKey;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public ScriptPubKeyBean getScriptPubKey() {
            return scriptPubKey;
        }

        public void setScriptPubKey(ScriptPubKeyBean scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
        }

        public static class ScriptPubKeyBean implements Serializable{
            private List<String> addresses;

            public List<String> getAddresses() {
                return addresses;
            }

            public void setAddresses(List<String> addresses) {
                this.addresses = addresses;
            }
        }
    }
}
