package block.guess.main.bean;

import java.io.Serializable;
import java.util.List;

public class HistoryBean implements Serializable{


    /**
     * totalItems : 48
     * from : 0
     * to : 10
     * items : [{"txid":"68228e0c721959dd0b17b61b5ac5c85cbe70da4c9c4cf57d47e5bc3540e238f4","confirmations":75,"created_at":1552321578,"op_category":{"category":6},"balance_diff":10000},{"txid":"9f2a2b3206cc287520c953526cba84804cbf9918bf422f72fe0577685777584a","confirmations":1537,"created_at":1551438391,"op_category":{"category":12},"balance_diff":568},{"txid":"be5bad469c4b460dbf6abc5c4ddc11dc1b6b5fede92bfddae0210a80a89dd8c1","confirmations":1543,"created_at":1551432464,"op_category":{"category":8},"balance_diff":-200359},{"txid":"968de50bfdf82a42c1495d13defdc85e7e4d59b69e9acf2a267b0dce39a8ce0c","confirmations":1544,"created_at":1551429291,"op_category":{"category":6},"balance_diff":1000000},{"txid":"9f57ef2dd8f2d406a4a4a1db425c533450d24958f414b5dff29ddf3702ecabb9","confirmations":20985,"created_at":1539688371,"op_category":{"category":11},"balance_diff":568},{"txid":"e483fdbc772a7d6b1172e8d011a0867f8c7aff22e814257b083465fb6b3d6eed","confirmations":21745,"created_at":1539224549,"op_category":{"category":11},"balance_diff":568},{"txid":"41f5b742e5272e2aa1a667099da491cd4eccb33956a1c4a655308a9b42440e97","confirmations":23441,"created_at":1538203229,"op_category":{"category":12},"balance_diff":568},{"txid":"1985944f97cbe03a9d359210d024904be6882bd7e1107eef5eb45af6278d638a","confirmations":23459,"created_at":1538193610,"op_category":{"category":11},"balance_diff":568},{"txid":"856b2b36c5011b35fcd966ffc82d3be71fa1fcd653773924d0ef8d6027db2720","confirmations":23702,"created_at":1538050500,"op_category":{"category":11},"balance_diff":568},{"txid":"4620e391697c1de8c3f66bce11dfdf42bbf0fe40903f94361e3d5420df451cef","confirmations":23883,"created_at":1537943842,"op_category":{"category":11},"balance_diff":568}]
     * pages_total : 5
     */

    private int totalItems;
    private int from;
    private int to;
    private int pages_total;
    private List<ItemsBean> items;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getPages_total() {
        return pages_total;
    }

    public void setPages_total(int pages_total) {
        this.pages_total = pages_total;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements Serializable{
        /**
         * txid : 68228e0c721959dd0b17b61b5ac5c85cbe70da4c9c4cf57d47e5bc3540e238f4
         * confirmations : 75
         * created_at : 1552321578
         * op_category : {"category":6}
         * balance_diff : 10000
         */

        private String txid;
        private int confirmations;
        private long created_at;
        private OpCategoryBean op_category;
        private int balance_diff;

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public int getConfirmations() {
            return confirmations;
        }

        public void setConfirmations(int confirmations) {
            this.confirmations = confirmations;
        }

        public long getCreated_at() {
            return created_at;
        }

        public void setCreated_at(long created_at) {
            this.created_at = created_at;
        }

        public OpCategoryBean getOp_category() {
            return op_category;
        }

        public void setOp_category(OpCategoryBean op_category) {
            this.op_category = op_category;
        }

        public int getBalance_diff() {
            return balance_diff;
        }

        public void setBalance_diff(int balance_diff) {
            this.balance_diff = balance_diff;
        }

        public static class OpCategoryBean implements Serializable{
            /**
             * category : 6
             */

            private int category;

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
                this.category = category;
            }
        }
    }
}
