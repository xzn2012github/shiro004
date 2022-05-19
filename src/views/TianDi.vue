<template>
    <div>
        <div>时间：2022年5月8日13时37分(北京时间)，星期日。</div>
        <div>
            <div id="h1">{{this.h1}}</div> <div id="h2">{{this.h2}}</div> <div id="h3">{{this.h3}}</div> <div id="h4">{{this.h4}}</div><br>
<div id="s1">{{this.s1}}</div> <div id="k11">{{this.k11}}</div><div id="k12">{{this.k12}}</div><div id="k13">{{this.k13}}</div><div id="k14">{{this.k14}}</div><br>
<div id="k21">{{this.k21}}</div><div id="k22">{{this.k22}}</div><div id="k23">{{this.k23}}</div><div id="k24">{{this.k24}}</div><br>
<div id="s2">{{this.s2}}</div><div id="k31">{{this.k31}}</div><div id="k32">{{this.k32}}</div><div id="k33">{{this.k33}}</div><div id="k34">{{this.k34}}</div><br>
<div id="k41">{{this.k41}}</div><div id="k42">{{this.k42}}</div><div id="k43">{{this.k43}}</div><div id="k44">{{this.k44}}</div><br>
<div id="s3">{{this.s3}}</div><div id="k51">{{this.k51}}</div><div id="k52">{{this.k52}}</div><div id="k53">{{this.k53}}</div><div id="k54">{{this.k54}}</div><br>
<div id="s4">{{this.s4}}</div><div id="k61">{{this.k61}}</div><div id="k62">{{this.k62}}</div><div id="k63">{{this.k63}}</div><div id="k64">{{this.k64}}</div>
</div>
<br>
    <router-link to="/TianDi/FiveGo"><el-button type="fiveGo" plain>统计五行</el-button></router-link>
    <router-view></router-view>

    </div>
    
</template>

<script>
export default {
    name: 'TianDi',

    data() {
        return {
            h1:"伤",
            h2:"财",
            h3:"日元",
            h4:"财",

            s1:"乾造",
            s2:"藏干",
            s3:"地势",
            s4:"纳音",

// K11_K24为乾造的两组值
            k11:"壬",
            k12:"乙",
            k13:"辛",
            k14:"乙（日空子、丑）",

            k21:"寅",
            k22:"巳",
            k23:"酉",
            k24:"未",

// K31_K44为藏干的两组值
            k31:"甲丙戊",
            k32:"庚丙戊",
            k33:"辛",
            k34:"乙己丁",

            k41:"才官印",
            k42:"劫官印",
            k43:"比",
            k44:"财枭杀",

//为地势的值
            k51:"胎",
            k52:"死",
            k53:"临官",
            k54:"衰",

            //为纳音的值
            k61:"金箔金",
            k62:"佛灯火",
            k63:"石榴木",
            k64:"沙中金",



            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style lang="scss" scoped>
#h1{
    float: left;
    margin-left: 500px;
}
#h2{
    float: left;
    margin-left: 50px;
}
#h3{
    float: left;
    margin-left: 50px;
}
#h4{
    float: left;
    margin-left: 50px;
}
//第二组
#s1{
    float: left;
    margin-left: -300px;
}
#k11{
    float: left;
    margin-left: -230px;
}
#k12{
    float: left;
    margin-left: -160px;
}
#k13{
    float: left;
    margin-left: -90px;
}
#k14{
    float: left;
    margin-left: -20px;
}

#k21{
    float: left;
    margin-left: -338px;
}
#k22{
    float: left;
    margin-left: -268px;
}
#k23{
    float: left;
    margin-left: -198px;
}
#k24{
    float: left;
    margin-left: -128px;
}

//第四组
#s2{
    float: left;
    margin-left: 430px;
}
#k31{
    float: left;
    margin-left: 38px;
}
#k32{
    float: left;
    margin-left: 23px;
}
#k33{
    float: left;
    margin-left: 23px;
}
#k34{
    float: left;
    margin-left: 50px;
}

#k41{
    float: left;
    margin-left: -258px;
}
#k42{
    float: left;
    margin-left: -188px;
}
#k43{
    float: left;
    margin-left: -118px;
}
#k44{
    float: left;
    margin-left: -48px;
}

//第五组
#s3{
    float: left;
    margin-left: 430px;
}
#k51{
    float: left;
    margin-left: 38px;
}
#k52{
    float: left;
    margin-left: 50px;
}
#k53{
    float: left;
    margin-left: 53px;
}
#k54{
    float: left;
    margin-left: 50px;
}

//第六组
#s4{
    float: left;
    margin-left: -302px;
}
#k61{
    float: left;
    margin-left: -235px;
}
#k62{
    float: left;
    margin-left: -160px;
}
#k63{
    float: left;
    margin-left: -90px;
}
#k64{
    float: left;
    margin-left: -20px;
}
</style>