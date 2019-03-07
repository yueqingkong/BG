package block.guess.betting.bean;

import java.io.Serializable;
import java.util.List;

public class LotteryDetailBean implements Serializable {


    /**
     * id : 83
     * contract_id : 51
     * category : 2
     * period : 2
     * random_number : 058
     * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[0,5,8],"completionTime":"2018-06-19 12:16:25Z","serialNumber":1190}
     * signature : ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=
     * open_time : 1529411027
     * height : 535359
     * open_height : 535360
     * open_block_hash : 0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa
     * status : 4
     * address : 1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p
     * winner_list : [{"id":1,"user_id":2,"contract_id":51,"reward":90000000,"status":2,"address":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","send_to_friend":1,"buy_tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","username":"hhhhg","avatar":"","times":0,"period":2,"category":2}]
     * lotteries_numbers : [{"id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]
     * purchase_history : [{"id":104,"identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","user_id":2,"contract_id":51,"times":10,"unit":100000,"total_amount":1000000,"tx_hash":"6deed536d5e715b575d853e47cfff71bbbc1c5b29eb177398b0687813557c03d","status":3,"category":2,"created_at":1529410584,"send_to_friend":1,"period":0},{"id":103,"identifier":"8f6d4bfa66f951e7d3de85e673376ea3f9ece8ce","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"4c00526444ce05863a663c2355afa84b67285b086180ac03f371f7e2fe15a6f2","status":3,"category":2,"created_at":1529410552,"send_to_friend":1,"period":0},{"id":102,"identifier":"4af71035fb3d329176a00375572d0308025d2387","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"da0254a920fc639efcf69e14ef6f072111d6a2697e032e5700d0656b588e8ef5","status":3,"category":2,"created_at":1529410547,"send_to_friend":1,"period":0},{"id":101,"identifier":"852288984e836562b36df787f2d28ebb8ab0f6af","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"b1185648d4a6fff143b1cdfe34336130e52f93e890b5baf9e0c4d58267ca4b44","status":3,"category":2,"created_at":1529410542,"send_to_friend":1,"period":0},{"id":100,"identifier":"b08a3f9c5f5a9e68beab0bdc73c42d579c3eccdf","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"226ebdfb2917a00919e089965caec0b88195883b7b1c815d0b7ff1e447c75e2e","status":3,"category":2,"created_at":1529410539,"send_to_friend":1,"period":0},{"id":99,"identifier":"8d4be9f1dbd4b4f8f027ed5a4cebe156089d3100","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"38487a36e3a43d5e268277cbe8aff1fd39129c20acce8fed24025defcbbac9c3","status":3,"category":2,"created_at":1529410535,"send_to_friend":1,"period":0},{"id":98,"identifier":"86b9ff57d8cd30a5f5d287fa3835cf168545a458","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"97e7d3dd9c3470a9c63ca86330b5376e2bb18a9b37c2dcf274843ffaa1ad2400","status":3,"category":2,"created_at":1529410530,"send_to_friend":1,"period":0},{"id":97,"identifier":"80a73b2a535d6ab8bec209137a9dcf72b5f0259a","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"ad8c4de56599f2113013df93835968dca5bf3987d2518b13e10aecb440a1073c","status":3,"category":2,"created_at":1529410526,"send_to_friend":1,"period":0},{"id":96,"identifier":"c131edf59d9936364f05909e492fcf65367add96","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"0eceb6f191dc0b89776ae86eea921ccb17c987279c8a9d9a6d6d2a1ef3036b9c","status":3,"category":2,"created_at":1529410522,"send_to_friend":1,"period":0},{"id":95,"identifier":"42a5b5b79c1b7141a571be2c645461b3d287a294","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"2bde23cda341ec5d4eb3e7511dd925ce7a41dfba58b2aaef6cf37f9c746b8728","status":3,"category":2,"created_at":1529410519,"send_to_friend":1,"period":0},{"id":94,"identifier":"8ca72b46a77f1bd2a52e71aae1ee72f9b768bf2e","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"1f73029db4fe0b2f964d9fdec88781585e63955c75f4edeb92143ece4dc75981","status":3,"category":2,"created_at":1529410514,"send_to_friend":1,"period":0},{"id":93,"identifier":"869bc1cb92bf6499dbcf0b864054ec397cd6a9e8","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"ab1f0391dd6a22114d940fdb63d23d932b6ade14525dca908b84d87125beae4d","status":3,"category":2,"created_at":1529410510,"send_to_friend":1,"period":0},{"id":92,"identifier":"58c60566b04c438e6bc3b8cd3de26d24c5aa3759","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"191cdea4b62dc0f55832e1c7254523e271f393b2c7227ccd6932697424788ab7","status":3,"category":2,"created_at":1529410505,"send_to_friend":1,"period":0},{"id":91,"identifier":"01945c1a02f5de110aa684a2cde1813037a26862","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"b036106bd0230e2232e91d2d90f31d69e8d5ca485d4d5fbf428e4d37a3101446","status":3,"category":2,"created_at":1529410491,"send_to_friend":1,"period":0},{"id":90,"identifier":"4d17cf80c1bbe95debdec448454f0c5365f34820","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"b7613130d0574a96fb88c88961036546dcc947071adc6523cee34e2334e26a6e","status":3,"category":2,"created_at":1529158892,"send_to_friend":1,"period":0},{"id":89,"identifier":"6859dd54126d8877d6535694dca817a92aa897d3","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"2b7091678d7157b670366dd3053dc99d15c8cac37ec8e9aeaf7a59eae01df45e","status":3,"category":2,"created_at":1529158884,"send_to_friend":1,"period":0},{"id":87,"identifier":"ef69d21c4dbe44b2d2e97fab15a023247955a89f","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"41f70b2010d1433693e0298dd3a239f9628587ee4d865b4d58ddeaba4e8e3b34","status":3,"category":2,"created_at":1529157946,"send_to_friend":1,"period":0},{"id":86,"identifier":"874e8dcad0cd2d3bdfe40efe7db2e6a37f18d036","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"6bcb7adb0773e1480bdc4e5393267b883d965b5a819be5488d4ab1612d306dce","status":3,"category":2,"created_at":1529157905,"send_to_friend":1,"period":0},{"id":85,"identifier":"b29406741672a9070949305d86f67e72d86bbb7b","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"17bf9446494655dfe6a7bf640aab0e61d000a21e0e4bd21b4bd55814aafd6446","status":3,"category":2,"created_at":1529157903,"send_to_friend":1,"period":0},{"id":84,"identifier":"f023584d17715a3f391d5d7ffe7f4fa6d3a35dc8","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"8d52d784024409bee5cd580249a64c002a38350eb66e3329ec8ff00d77346b83","status":3,"category":2,"created_at":1529157898,"send_to_friend":1,"period":0},{"id":83,"identifier":"4160415b4a6a2d759829a2fa23e3c222b3261ae1","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"382047230b71968aa7698ad45cd55a572cb06a6267ed86b08f4abd6b36978a8c","status":3,"category":2,"created_at":1529157894,"send_to_friend":1,"period":0},{"id":82,"identifier":"32354b4dacab6a6763899942bdcb31b3c2e64e8e","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"c368a8ba7cc1cc9cfee0d0dede55ea4c449877d9009f9dbc16ed950092d5b0ff","status":3,"category":2,"created_at":1529157889,"send_to_friend":1,"period":0},{"id":81,"identifier":"1b28fd4d60f397eac67982eaa8f9e9703deb2ae0","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"6c68de458e75441f875b8ba55cce9ee486bae4fdf167c582e03ba47e242b631b","status":3,"category":2,"created_at":1529157876,"send_to_friend":1,"period":0},{"id":80,"identifier":"1ca3f18e1cb5348f88c84077093499876e65dd42","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"7bded573acdeb08172ef662509d75ea005b09aefc4ba1cfa37fe2286b2fab46a","status":3,"category":2,"created_at":1529157872,"send_to_friend":1,"period":0},{"id":79,"identifier":"2c262f5b395bc27e089043b8902676117c2214fb","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"b7a85119345627b2a38f18ecfb666d0b74750a843ad3784fe67224e3bb5b1875","status":3,"category":2,"created_at":1529157845,"send_to_friend":1,"period":0},{"id":78,"identifier":"6d3d370ee491f113da576fd2bec636ffa948f19d","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"8e747253aac3a2250743c727fda9a256a5fcb586db722a6ead32a2212dd90f94","status":3,"category":2,"created_at":1529157840,"send_to_friend":1,"period":0},{"id":77,"identifier":"15342559db782d2da4329c7af22ca409c38fa51d","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"prize":90000000,"tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","status":2,"category":2,"created_at":1529157832,"send_to_friend":1,"period":0},{"id":76,"identifier":"68416becd06f2b5fdcf95641c8783a11043d1d51","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"ec6b3e11d1767ee08d90e63fafac233b8d0645b30b945e8f9d5f611976aeb646","status":3,"category":2,"created_at":1529157828,"send_to_friend":1,"period":0},{"id":75,"identifier":"3aad8bb11c1ab9a2c02a7c20e14ca5741982dbaa","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"a6ace647d368a2370da34cd0578dbdb02d4b416a5a99460e3c88e7cdb1b05fa3","status":3,"category":2,"created_at":1529157823,"send_to_friend":1,"period":0},{"id":74,"identifier":"844a957fbbbc36a4e15bd5e57fd7eda4f09d89a2","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"5ff3c1cf2e5e276dd90b5f8316d4563ae172d07792e45a539d318b048bf009e6","status":3,"category":2,"created_at":1529157819,"send_to_friend":1,"period":0},{"id":73,"identifier":"4a0fb507117bdd20b4706fe39e37a584deb7ca52","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"4b611aaca5ec9df9cafd552f6fb025fae40ae91096b1f9ba708c8ece8415dd5b","status":3,"category":2,"created_at":1529157814,"send_to_friend":1,"period":0},{"id":72,"identifier":"93d3af60456114438177f0e965ba1c215ff165ad","user_id":2,"contract_id":51,"times":30,"unit":100000,"total_amount":3000000,"tx_hash":"cd43aafd70bb4587b779b46eaa8870349df59a4d567aac025405c40e9a050e1e","status":3,"category":2,"created_at":1529157807,"send_to_friend":1,"period":0},{"id":71,"identifier":"9bcdc4f7661c289c6b111dfe52ccaad861e3bf11","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"029453f5febad72c1d2da70067fe01fe662273b793bf9255087997377dcb4e3b","status":3,"category":2,"created_at":1529061922,"send_to_friend":1,"period":0},{"id":70,"identifier":"1cc162989d02ce69e42bd774a3d1dba88a9828f7","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"3e4eb153a2bbf4c9bea6b0e8604e4d0bdee9e35d26ac26b30143db9d5d8cb647","status":3,"category":2,"created_at":1529061905,"send_to_friend":1,"period":0},{"id":69,"identifier":"d9a650220d75931c243a93f4c49cd7934b3dea7f","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"d6452429ce195832fc1beb715df4b0656a1802cf4e0837029240256f01b60ae6","status":3,"category":2,"created_at":1529061901,"send_to_friend":1,"period":0},{"id":68,"identifier":"2c810af3a39082ddc8b38b7c9e8745b7b93399dc","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"7d728fa900190233271c30e544ddc1c4b88c14ab0e31e205b09c13416dcd0ed9","status":3,"category":2,"created_at":1529061897,"send_to_friend":1,"period":0},{"id":67,"identifier":"543548847a669073c7821b9058532482645c0f1c","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"b30323dc4ca8f27f63f7ecf032b5fdbef6d3cb9e776750a76691441e0ff1cc48","status":3,"category":2,"created_at":1529061893,"send_to_friend":1,"period":0},{"id":66,"identifier":"1c0ed993b9b2b0571ec7933cab9df1c4064f2e85","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"2caed77a67c1b8d19f9c51d5b2a288785faaaa5f3bb43eec032707a8e527e8db","status":3,"category":2,"created_at":1529061889,"send_to_friend":1,"period":0},{"id":65,"identifier":"373c69e5a9fc4b7b5e1d25b1477df978054d24cd","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"3b1cd111bacd4df590a8b7f042a3c81cf4c5a047a6975d0db130e91c1632aa2c","status":3,"category":2,"created_at":1529061886,"send_to_friend":1,"period":0},{"id":64,"identifier":"559d82d80a9bc8c209dd4e666298266db28185ff","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"8a71dc5a27acaa0a54f0b3e267b11858b86b21a5b39308faded38e8fa12936ea","status":3,"category":2,"created_at":1529061880,"send_to_friend":1,"period":0},{"id":63,"identifier":"65446df809c560b6dc47bb410c0d69211a761fd5","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"4e52bcf47be0ba42891305ee3b43708fb757df920784ba960eda8b4a0a728c3c","status":3,"category":2,"created_at":1529061876,"send_to_friend":1,"period":0},{"id":62,"identifier":"2483edbf55ff4813f23f60a055e30482a34d4733","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"729a1de956c59aa80f5e3af7f192466a2d2dffac8bbb8acf143d4c3390a35d66","status":3,"category":2,"created_at":1529061872,"send_to_friend":1,"period":0},{"id":61,"identifier":"c30921cdfff668db9a7f710d4b61ce4776294f7d","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"8f7b85f5eeaca2fafcae4425f8ebf0c1a7f12117aa79bf6c1244782b848c7a69","status":3,"category":2,"created_at":1529061866,"send_to_friend":1,"period":0},{"id":60,"identifier":"d3c7581276dedc70084efd4a08822be07a258e6f","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"faf1d785c578b8aee2da87e696b8ea864c3886dc9c52f10f137d4506c0e03b0e","status":3,"category":2,"created_at":1529061860,"send_to_friend":1,"period":0},{"id":59,"identifier":"4ef45516c97f9b2c22d2bcb3668a4f2d0f51124d","user_id":2,"contract_id":51,"times":4,"unit":100000,"total_amount":400000,"tx_hash":"37ab51825b14bb76782a081921aec48793a2308068b72ccf8928b30263144847","status":3,"category":2,"created_at":1529061854,"send_to_friend":1,"period":0},{"id":58,"identifier":"6ef98c921bf0e1f6ef57f4e956901be51848632b","user_id":2,"contract_id":51,"times":8,"unit":100000,"total_amount":800000,"tx_hash":"b80976bfea20ae716d256f6b4f6b4d715c42e0e5c0373d1ac1ce4d0efd636421","status":3,"category":2,"created_at":1529061842,"send_to_friend":1,"period":0}]
     */

    private int id;
    private int contract_id;
    private int category;
    private int period;
    private String random_number;
    private RandomBean random;
    private String signature;
    private int open_time;
    private int height;
    private int open_height;
    private String open_block_hash;
    private int status;
    private String address;
    private List<WinnerListBean> winner_list;
    private List<LotteriesNumbersBean> lotteries_numbers;
    private List<PurchaseHistoryBean> purchase_history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getRandom_number() {
        return random_number;
    }

    public void setRandom_number(String random_number) {
        this.random_number = random_number;
    }

    public RandomBean getRandom() {
        return random;
    }

    public void setRandom(RandomBean random) {
        this.random = random;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getOpen_time() {
        return open_time;
    }

    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOpen_height() {
        return open_height;
    }

    public void setOpen_height(int open_height) {
        this.open_height = open_height;
    }

    public String getOpen_block_hash() {
        return open_block_hash;
    }

    public void setOpen_block_hash(String open_block_hash) {
        this.open_block_hash = open_block_hash;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<WinnerListBean> getWinner_list() {
        return winner_list;
    }

    public void setWinner_list(List<WinnerListBean> winner_list) {
        this.winner_list = winner_list;
    }

    public List<LotteriesNumbersBean> getLotteries_numbers() {
        return lotteries_numbers;
    }

    public void setLotteries_numbers(List<LotteriesNumbersBean> lotteries_numbers) {
        this.lotteries_numbers = lotteries_numbers;
    }

    public List<PurchaseHistoryBean> getPurchase_history() {
        return purchase_history;
    }

    public void setPurchase_history(List<PurchaseHistoryBean> purchase_history) {
        this.purchase_history = purchase_history;
    }

    public static class RandomBean {
        /**
         * method : generateSignedIntegers
         * hashedApiKey : czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==
         * n : 3
         * min : 0
         * max : 9
         * replacement : true
         * base : 10
         * data : [0,5,8]
         * completionTime : 2018-06-19 12:16:25Z
         * serialNumber : 1190
         */

        private String method;
        private String hashedApiKey;
        private int n;
        private int min;
        private int max;
        private boolean replacement;
        private int base;
        private String completionTime;
        private int serialNumber;
        private List<Integer> data;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getHashedApiKey() {
            return hashedApiKey;
        }

        public void setHashedApiKey(String hashedApiKey) {
            this.hashedApiKey = hashedApiKey;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public boolean isReplacement() {
            return replacement;
        }

        public void setReplacement(boolean replacement) {
            this.replacement = replacement;
        }

        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public String getCompletionTime() {
            return completionTime;
        }

        public void setCompletionTime(String completionTime) {
            this.completionTime = completionTime;
        }

        public int getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
        }

        public List<Integer> getData() {
            return data;
        }

        public void setData(List<Integer> data) {
            this.data = data;
        }
    }

    public static class WinnerListBean {
        /**
         * id : 1
         * user_id : 2
         * contract_id : 51
         * reward : 90000000
         * status : 2
         * address : 1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h
         * send_to_friend : 1
         * buy_tx_hash : 73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082
         * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
         * username : hhhhg
         * avatar :
         * times : 0
         * period : 2
         * category : 2
         */

        private int id;
        private int user_id;
        private int contract_id;
        private int reward;
        private int status;
        private String address;
        private int send_to_friend;
        private String buy_tx_hash;
        private String tx_hash;
        private String username;
        private String avatar;
        private int times;
        private int period;
        private int category;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getContract_id() {
            return contract_id;
        }

        public void setContract_id(int contract_id) {
            this.contract_id = contract_id;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getSend_to_friend() {
            return send_to_friend;
        }

        public void setSend_to_friend(int send_to_friend) {
            this.send_to_friend = send_to_friend;
        }

        public String getBuy_tx_hash() {
            return buy_tx_hash;
        }

        public void setBuy_tx_hash(String buy_tx_hash) {
            this.buy_tx_hash = buy_tx_hash;
        }

        public String getTx_hash() {
            return tx_hash;
        }

        public void setTx_hash(String tx_hash) {
            this.tx_hash = tx_hash;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class LotteriesNumbersBean {
        /**
         * id : 77
         * contract_id : 51
         * award_number : 193
         * open_time : 1529411027
         * height : 535360
         * category : 1
         */

        private int id;
        private int contract_id;
        private String award_number;
        private int open_time;
        private int height;
        private int category;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getContract_id() {
            return contract_id;
        }

        public void setContract_id(int contract_id) {
            this.contract_id = contract_id;
        }

        public String getAward_number() {
            return award_number;
        }

        public void setAward_number(String award_number) {
            this.award_number = award_number;
        }

        public int getOpen_time() {
            return open_time;
        }

        public void setOpen_time(int open_time) {
            this.open_time = open_time;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class PurchaseHistoryBean {
        /**
         * id : 104
         * identifier : b0624c00eaba7090a717774fe0f5f8da6104d2fb
         * user_id : 2
         * contract_id : 51
         * times : 10
         * unit : 100000
         * total_amount : 1000000
         * tx_hash : 6deed536d5e715b575d853e47cfff71bbbc1c5b29eb177398b0687813557c03d
         * status : 3
         * category : 2
         * created_at : 1529410584
         * send_to_friend : 1
         * period : 0
         * prize : 90000000
         */

        private int id;
        private String identifier;
        private int user_id;
        private int contract_id;
        private int times;
        private int unit;
        private int total_amount;
        private String tx_hash;
        private int status;
        private int category;
        private int created_at;
        private int send_to_friend;
        private int period;
        private int prize;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getContract_id() {
            return contract_id;
        }

        public void setContract_id(int contract_id) {
            this.contract_id = contract_id;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public int getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(int total_amount) {
            this.total_amount = total_amount;
        }

        public String getTx_hash() {
            return tx_hash;
        }

        public void setTx_hash(String tx_hash) {
            this.tx_hash = tx_hash;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getSend_to_friend() {
            return send_to_friend;
        }

        public void setSend_to_friend(int send_to_friend) {
            this.send_to_friend = send_to_friend;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getPrize() {
            return prize;
        }

        public void setPrize(int prize) {
            this.prize = prize;
        }
    }
}
