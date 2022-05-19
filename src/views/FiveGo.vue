<template>
  <div>
    <div id="hiddenTianDi" style="display: none">
      <div id="h1">{{ this.h1 }}</div>
      <div id="h2">{{ this.h2 }}</div>
      <div id="h3">{{ this.h3 }}</div>
      <div id="h4">{{ this.h4 }}</div>
      <br />
      <div id="s1">{{ this.s1 }}</div>
      <div id="k11">{{ this.k11 }}</div>
      <div id="k12">{{ this.k12 }}</div>
      <div id="k13">{{ this.k13 }}</div>
      <div id="k14">{{ this.k14 }}</div>
      <br />
      <div id="k21">{{ this.k21 }}</div>
      <div id="k22">{{ this.k22 }}</div>
      <div id="k23">{{ this.k23 }}</div>
      <div id="k24">{{ this.k24 }}</div>
      <br />
      <div id="s2">{{ this.s2 }}</div>
      <div id="k31">{{ this.k31 }}</div>
      <div id="k32">{{ this.k32 }}</div>
      <div id="k33">{{ this.k33 }}</div>
      <div id="k34">{{ this.k34 }}</div>
      <br />
      <div id="k41">{{ this.k41 }}</div>
      <div id="k42">{{ this.k42 }}</div>
      <div id="k43">{{ this.k43 }}</div>
      <div id="k44">{{ this.k44 }}</div>
      <br />
      <div id="s3">{{ this.s3 }}</div>
      <div id="k51">{{ this.k51 }}</div>
      <div id="k52">{{ this.k52 }}</div>
      <div id="k53">{{ this.k53 }}</div>
      <div id="k54">{{ this.k54 }}</div>
      <br />
      <div id="s4">{{ this.s4 }}</div>
      <div id="k61">{{ this.k61 }}</div>
      <div id="k62">{{ this.k62 }}</div>
      <div id="k63">{{ this.k63 }}</div>
      <div id="k64">{{ this.k64 }}</div>
    </div>
    <div id="five">
      水：{{ water }} 火：{{ fire }} 木：{{ tree }} 金：{{ gold }} 土：{{
        land
      }}
    </div>
    <div>
      <div id="main" style="width: 900px; height: 300px"></div>
    </div>
  </div>
</template>

<script>
import echarts from "echarts";
export default {
  name: "FiveGo",

  data() {
    return {
      water: "",
      fire: "",
      tree: "",
      gold: "",
      land: "",

      h1: "伤",
      h2: "财",
      h3: "日元",
      h4: "财",

      s1: "乾造",
      s2: "藏干",
      s3: "地势",
      s4: "纳音",

      // K11_K24为乾造的两组值
      k11: "壬",
      k12: "乙",
      k13: "辛",
      k14: "乙（日空子、丑）",

      k21: "寅",
      k22: "巳",
      k23: "酉",
      k24: "未",

      // K31_K44为藏干的两组值
      k31: "甲丙戊",
      k32: "庚丙戊",
      k33: "辛",
      k34: "乙己丁",

      k41: "才官印",
      k42: "劫官印",
      k43: "比",
      k44: "财枭杀",

      //为地势的值
      k51: "胎",
      k52: "死",
      k53: "临官",
      k54: "衰",

      //为纳音的值
      k61: "金箔金",
      k62: "佛灯火",
      k63: "石榴木",
      k64: "沙中金",
    };
  },

  mounted() {
    this.$nextTick(function () {
      this.getPie();
    });
  },

  methods: {
    getPie() {
      let countWater = 0;
      //水water
      //1.判断天干K11-K14
      if (this.k11 == "壬" || this.k11 == "癸") {
        countWater = countWater + 1;
      }
      if (this.k12 == "壬" || this.k12 == "癸") {
        countWater = countWater + 1;
      }
      if (this.k13 == "壬" || this.k13 == "癸") {
        countWater = countWater + 1;
      }
      if (this.k14 == "壬" || this.k14 == "癸") {
        countWater = countWater + 1;
      }

      //2.判断月柱地支K22
      if (this.k22 == "亥" || this.k22 == "子") {
        countWater = countWater + 0.5;
      }

       //3.地支藏干K31-K34
      if (this.k31.match("壬")) {
        countWater = countWater + 1;
      }
            if (this.k31.match("癸")) {
        countWater = countWater + 1;
      }
            if (this.k32.match("壬")) {
        countWater = countWater + 1;
      }
            if (this.k32.match("癸")) {
        countWater = countWater + 1;
      }
                  if (this.k33.match("壬")) {
        countWater = countWater + 1;
      }
            if (this.k33.match("癸")) {
        countWater = countWater + 1;
      }
                  if (this.k34.match("壬")) {
        countWater = countWater + 1;
      }
            if (this.k34.match("癸")) {
        countWater = countWater + 1;
      }
        //4.天干化合K11跟K32化，K12跟K31、K33化，K13跟K32、K34化，K14跟K33化
              //(1)K11跟K32化 
      if(this.k32.match("辛") && !this.k32.match("丙")){
      let xinArray = this.k32.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k11 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k11 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k11 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k11 == "丙" && xinNum == 4){
countWater = countWater + 5;
      }else if(this.k11 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k11 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k11 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k32.match("辛") && this.k32.match("丙")){
          let xinArray = this.k32.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k32.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k11 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k11 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k11 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k11 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k11 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k11 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k11 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k11 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k11 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k11 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k11 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k11 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k11 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }

      }

      // (2)K12跟K31、K33化，
      //(一)K12跟K31
      if(this.k31.match("辛") && !this.k31.match("丙")){
      let xinArray = this.k31.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k12 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k12 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k12 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 4){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k31.match("辛") && this.k31.match("丙")){
          let xinArray = this.k31.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k31.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k12 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }
      
      }

      //(二)K12跟K33
      if(this.k33.match("辛") && !this.k33.match("丙")){
      let xinArray = this.k33.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k12 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k12 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k12 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 4){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k33.match("辛") && this.k33.match("丙")){
          let xinArray = this.k33.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k33.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k12 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k12 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k12 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }
      
      }

      //(3)K13跟K32、K34化
      //(一)K13跟K32
 if(this.k32.match("辛") && !this.k32.match("丙")){
      let xinArray = this.k32.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k13 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k13 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k13 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 4){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k32.match("辛") && this.k32.match("丙")){
          let xinArray = this.k32.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k32.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k13 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }
      
      }

      //(二)K13跟K34
if(this.k34.match("辛") && !this.k34.match("丙")){
      let xinArray = this.k34.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k13 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k13 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k13 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 4){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k34.match("辛") && this.k34.match("丙")){
          let xinArray = this.k34.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k34.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k13 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k13 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k13 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }
      
      }

      //(4)K14跟K33化
if(this.k33.match("辛") && !this.k33.match("丙")){
      let xinArray = this.k33.split("辛");
      let xinNum = xinArray.length - 1;
      if (this.k14 == "丙" && xinNum == 1) {
        countWater = countWater + 2;
      }else if(this.k14 == "丙" && xinNum == 2){
countWater = countWater + 3;
      }else if(this.k14 == "丙" && xinNum == 3){
countWater = countWater + 4;
      }else if(this.k14 == "丙" && xinNum == 4){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 5){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 6){
countWater = countWater + 7;
      }else if(this.k14 == "丙" && xinNum == 7){
countWater = countWater + 8;
      }
      }else if(this.k33.match("辛") && this.k33.match("丙")){
          let xinArray = this.k33.split("辛");
      let xinNum = xinArray.length - 1;
      let bingArray = this.k33.split("丙");
      let bingNum = bingArray.length - 1;

      if (this.k14 == "丙" && xinNum == 6 && bingNum == 1) {
        countWater = countWater + 8;
      }else if(this.k14 == "丙" && xinNum == 5 && bingNum == 1){
countWater = countWater + 7;
      }else if(this.k14 == "丙" && xinNum == 4 && bingNum == 1){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 3 && bingNum == 1){
countWater = countWater + 5;
      }else if(this.k14 == "丙" && xinNum == 2 && bingNum == 1){
countWater = countWater + 4;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 1){
countWater = countWater + 3;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 2){
countWater = countWater + 4;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 3){
countWater = countWater + 5;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 4){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 5){
countWater = countWater + 7;
      }else if(this.k14 == "丙" && xinNum == 1 && bingNum == 6){
countWater = countWater + 8;
      }else if(this.k14 == "丙" && xinNum == 2 && bingNum == 5){
countWater = countWater + 8;
      }else if(this.k14 == "丙" && xinNum == 3 && bingNum == 4){
countWater = countWater + 8;
      }else if(this.k14 == "丙" && xinNum == 2 && bingNum == 4){
countWater = countWater + 7;
      }else if(this.k14 == "丙" && xinNum == 2 && bingNum == 3){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 3 && bingNum == 2){
countWater = countWater + 6;
      }else if(this.k14 == "丙" && xinNum == 4 && bingNum == 3){
countWater = countWater + 8;
      }else if(this.k14 == "丙" && xinNum == 2 && bingNum == 2){
countWater = countWater + 5;
      }
      
      }

      //5.判断地支六合
      let DiZhiLiuHe = this.k21 + this.k22 + this.k23 + this.k24;
      if(DiZhiLiuHe.match("申") && DiZhiLiuHe.match("己")){
          let shenArrayDiZhiLiuHe = DiZhiLiuHe.split("申");
          let shenNumDiZhiLiuHe = shenArrayDiZhiLiuHe.length - 1;
          let jiArrayDiZhiLiuHe = DiZhiLiuHe.split("己");
          let jiNumDiZhiLiuHe = jiArrayDiZhiLiuHe.length - 1;
          if(shenNumDiZhiLiuHe == 1 && jiNumDiZhiLiuHe == 1){
              countWater = countWater + 1;
          }else if(shenNumDiZhiLiuHe == 1 && jiNumDiZhiLiuHe == 2){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 1 && jiNumDiZhiLiuHe == 3){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && jiNumDiZhiLiuHe == 1){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 3 && jiNumDiZhiLiuHe == 1){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && jiNumDiZhiLiuHe == 2){
              countWater = countWater + 4;
          }
      }

      //6.判断生地半合
      let ShengDiBanHe = this.k21 + this.k22 + this.k23 + this.k24;
      if(ShengDiBanHe.match("申") && ShengDiBanHe.match("子")){
          let shenArrayShengDiBanHe = ShengDiBanHe.split("申");
          let shenNumShengDiBanHe = shenArrayShengDiBanHe.length - 1;
          let ziArrayShengDiBanHe = ShengDiBanHe.split("子");
          let ziNumShengDiBanHe = ziArrayShengDiBanHe.length - 1;
          if(shenNumShengDiBanHe == 1 && ziNumShengDiBanHe == 1){
              countWater = countWater + 1;
          }else if(shenNumDiZhiLiuHe == 1 && ziNumShengDiBanHe == 2){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 1 && ziNumShengDiBanHe == 3){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && ziNumShengDiBanHe == 1){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 3 && ziNumShengDiBanHe == 1){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && ziNumShengDiBanHe == 2){
              countWater = countWater + 4;
          }
      }

      //7.判断墓地半合
      let MuDiBanHe = this.k21 + this.k22 + this.k23 + this.k24;
      if(MuDiBanHe.match("子") && MuDiBanHe.match("辰")){
          let ziArrayMuDiBanHe = MuDiBanHe.split("子");
          let ziNumMuDiBanHe = ziArrayMuDiBanHe.length - 1;
          let chenArrayMuDiBanHe = MuDiBanHe.split("辰");
          let chenNumMuDiBanHe = chenArrayMuDiBanHe.length - 1;
          if(ziNumMuDiBanHe == 1 && chenNumMuDiBanHe == 1){
              countWater = countWater + 1;
          }else if(shenNumDiZhiLiuHe == 1 && chenNumMuDiBanHe == 2){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 1 && chenNumMuDiBanHe == 3){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && chenNumMuDiBanHe == 1){
              countWater = countWater + 2;
          }else if(shenNumDiZhiLiuHe == 3 && chenNumMuDiBanHe == 1){
              countWater = countWater + 3;
          }else if(shenNumDiZhiLiuHe == 2 && chenNumMuDiBanHe == 2){
              countWater = countWater + 4;
          }
      }

      //8.判断地支三合
      let DiZhiSanHe = this.k21 + this.k22 + this.k23 + this.k24;
      if(DiZhiSanHe.match("申") && DiZhiSanHe.match("子") && DiZhiSanHe.match("辰")){
          let shenArrayDiZhiSanHe = DiZhiSanHe.split("申");
          let shenNumDiZhiSanHe = shenArrayDiZhiSanHe.length - 1;
          let ziArrayDiZhiSanHe = DiZhiSanHe.split("子");
          let ziNumDiZhiSanHe = ziArrayDiZhiSanHe.length - 1;
          let chenArrayDiZhiSanHe = DiZhiSanHe.split("辰");
          let chenNumDiZhiSanHe = chenArrayDiZhiSanHe.length - 1;
          if(shenNumDiZhiSanHe == 1 && ziNumDiZhiSanHe == 1 && chenNumDiZhiSanHe == 1){
              countWater = countWater + 2;
          }else if(shenNumDiZhiSanHe == 1 && ziNumDiZhiSanHe == 1 && chenNumDiZhiSanHe == 2){
              countWater = countWater + 3;
          }else if(shenNumDiZhiSanHe == 1 && ziNumDiZhiSanHe == 2 && chenNumDiZhiSanHe == 2){
              countWater = countWater + 3;
          }else if(shenNumDiZhiSanHe == 2 && ziNumDiZhiSanHe == 1 && chenNumDiZhiSanHe == 1){
              countWater = countWater + 3;
          }
      }

      //9.三个地支
let SanGeDiZhi = this.k21 + this.k22 + this.k23 + this.k24;
      if(SanGeDiZhi.match("亥")){
          let haiArraySanGeDiZhi = SanGeDiZhi.split("亥");
          let haiNumSanGeDiZhi = haiArraySanGeDiZhi.length - 1;
          
          if(haiNumSanGeDiZhi == 3){
              countWater = countWater + 3;
          }
      }
      if(SanGeDiZhi.match("子")){
          let ziArraySanGeDiZhi = SanGeDiZhi.split("子");
          let ziNumSanGeDiZhi = ziArraySanGeDiZhi.length - 1;
          
          if(ziNumSanGeDiZhi == 3){
              countWater = countWater + 3;
          }
      }

      //10.判断地支三会
      
      let DiZhiSanHui = this.k21 + this.k22 + this.k23 + this.k24;
      if(DiZhiSanHui.match("亥") && DiZhiSanHui.match("子") && DiZhiSanHui.match("丑")){
          let haiArrayDiZhiSanHui = DiZhiSanHui.split("亥");
          let haiNumDiZhiSanHui = haiArrayDiZhiSanHui.length - 1;
          let ziArrayDiZhiSanHui = DiZhiSanHui.split("子");
          let ziNumDiZhiSanHui = ziArrayDiZhiSanHui.length - 1;
          let chouArrayDiZhiSanHui = DiZhiSanHui.split("丑");
          let chouNumDiZhiSanHui = chouArrayDiZhiSanHui.length - 1;
          if(haiNumDiZhiSanHui == 1 && ziNumDiZhiSanHui == 1 && chouNumDiZhiSanHui == 1){
              countWater = countWater + 3;
          }else if(haiNumDiZhiSanHui == 1 && ziNumDiZhiSanHui == 1 && chouNumDiZhiSanHui == 2){
              countWater = countWater + 3;
          }else if(haiNumDiZhiSanHui == 1 && ziNumDiZhiSanHui == 2 && chouNumDiZhiSanHui == 2){
              countWater = countWater + 3;
          }else if(haiNumDiZhiSanHui == 2 && ziNumDiZhiSanHui == 1 && chouNumDiZhiSanHui == 1){
              countWater = countWater + 3;
          }
      }

      //11.判断四柱纳音K11-K14与K21-K24两两组合
      //(1)K11和K21
if(this.k11 == "丙" && this.k21 == "子"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k21 == "丑"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k21 == "申"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k21 == "酉"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k21 == "辰"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k21 == "巳"){
    countWater = countWater + 1;
}
if(this.k11 == "丙" && this.k21 == "午"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k21 == "未"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k21 == "寅"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k21 == "卯"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k21 == "戌"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k21 == "亥"){
    countWater = countWater + 1;
}



       //(1)K11和K22
if(this.k11 == "丙" && this.k22 == "子"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k22 == "丑"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k22 == "申"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k22 == "酉"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k22 == "辰"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k22 == "巳"){
    countWater = countWater + 1;
}
if(this.k11 == "丙" && this.k22 == "午"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k22 == "未"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k22 == "寅"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k22 == "卯"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k22 == "戌"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k22 == "亥"){
    countWater = countWater + 1;
}




        //(1)K11和K23
if(this.k11 == "丙" && this.k23 == "子"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k23 == "丑"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k23 == "申"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k23 == "酉"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k23 == "辰"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k23 == "巳"){
    countWater = countWater + 1;
}
if(this.k11 == "丙" && this.k23 == "午"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k23 == "未"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k23 == "寅"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k23 == "卯"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k23 == "戌"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k23 == "亥"){
    countWater = countWater + 1;
}




         //(1)K11和K24
if(this.k11 == "丙" && this.k24 == "子"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k24 == "丑"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k24 == "申"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k24 == "酉"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k24 == "辰"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k24 == "巳"){
    countWater = countWater + 1;
}
if(this.k11 == "丙" && this.k24 == "午"){
    countWater = countWater + 1;
}
if(this.k11 == "丁" && this.k24 == "未"){
    countWater = countWater + 1;
}
if(this.k11 == "甲" && this.k24 == "寅"){
    countWater = countWater + 1;
}
if(this.k11 == "乙" && this.k24 == "卯"){
    countWater = countWater + 1;
}
if(this.k11 == "壬" && this.k24 == "戌"){
    countWater = countWater + 1;
}
if(this.k11 == "癸" && this.k24 == "亥"){
    countWater = countWater + 1;
}




                //(1)K12和K21
if(this.k12 == "丙" && this.k21 == "子"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k21 == "丑"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k21 == "申"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k21 == "酉"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k21 == "辰"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k21 == "巳"){
    countWater = countWater + 1;
}
if(this.k12 == "丙" && this.k21 == "午"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k21 == "未"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k21 == "寅"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k21 == "卯"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k21 == "戌"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k21 == "亥"){
    countWater = countWater + 1;
}



       //(1)K12和K22
if(this.k12 == "丙" && this.k22 == "子"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k22 == "丑"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k22 == "申"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k22 == "酉"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k22 == "辰"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k22 == "巳"){
    countWater = countWater + 1;
}
if(this.k12 == "丙" && this.k22 == "午"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k22 == "未"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k22 == "寅"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k22 == "卯"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k22 == "戌"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k22 == "亥"){
    countWater = countWater + 1;
}



        //(1)K12和K23
if(this.k12 == "丙" && this.k23 == "子"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k23 == "丑"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k23 == "申"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k23 == "酉"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k23 == "辰"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k23 == "巳"){
    countWater = countWater + 1;
}
if(this.k12 == "丙" && this.k23 == "午"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k23 == "未"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k23 == "寅"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k23 == "卯"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k23 == "戌"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k23 == "亥"){
    countWater = countWater + 1;
}



         //(1)K12和K24
if(this.k12 == "丙" && this.k24 == "子"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k24 == "丑"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k24 == "申"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k24 == "酉"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k24 == "辰"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k24 == "巳"){
    countWater = countWater + 1;
}
if(this.k12 == "丙" && this.k24 == "午"){
    countWater = countWater + 1;
}
if(this.k12 == "丁" && this.k24 == "未"){
    countWater = countWater + 1;
}
if(this.k12 == "甲" && this.k24 == "寅"){
    countWater = countWater + 1;
}
if(this.k12 == "乙" && this.k24 == "卯"){
    countWater = countWater + 1;
}
if(this.k12 == "壬" && this.k24 == "戌"){
    countWater = countWater + 1;
}
if(this.k12 == "癸" && this.k24 == "亥"){
    countWater = countWater + 1;
}


                         //(1)K13和K21
if(this.k13 == "丙" && this.k21 == "子"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k21 == "丑"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k21 == "申"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k21 == "酉"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k21 == "辰"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k21 == "巳"){
    countWater = countWater + 1;
}
if(this.k13 == "丙" && this.k21 == "午"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k21 == "未"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k21 == "寅"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k21 == "卯"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k21 == "戌"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k21 == "亥"){
    countWater = countWater + 1;
}




       //(1)K13和K22
if(this.k13 == "丙" && this.k22 == "子"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k22 == "丑"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k22 == "申"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k22 == "酉"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k22 == "辰"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k22 == "巳"){
    countWater = countWater + 1;
}
if(this.k13 == "丙" && this.k22 == "午"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k22 == "未"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k22 == "寅"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k22 == "卯"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k22 == "戌"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k22 == "亥"){
    countWater = countWater + 1;
}



        //(1)K13和K23
if(this.k13 == "丙" && this.k23 == "子"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k23 == "丑"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k23 == "申"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k23 == "酉"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k23 == "辰"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k23 == "巳"){
    countWater = countWater + 1;
}
if(this.k13 == "丙" && this.k23 == "午"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k23 == "未"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k23 == "寅"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k23 == "卯"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k23 == "戌"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k23 == "亥"){
    countWater = countWater + 1;
}



         //(1)K13和K24
if(this.k13 == "丙" && this.k24 == "子"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k24 == "丑"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k24 == "申"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k24 == "酉"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k24 == "辰"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k24 == "巳"){
    countWater = countWater + 1;
}
if(this.k13 == "丙" && this.k24 == "午"){
    countWater = countWater + 1;
}
if(this.k13 == "丁" && this.k24 == "未"){
    countWater = countWater + 1;
}
if(this.k13 == "甲" && this.k24 == "寅"){
    countWater = countWater + 1;
}
if(this.k13 == "乙" && this.k24 == "卯"){
    countWater = countWater + 1;
}
if(this.k13 == "壬" && this.k24 == "戌"){
    countWater = countWater + 1;
}
if(this.k13 == "癸" && this.k24 == "亥"){
    countWater = countWater + 1;
}



                                //(1)K14和K21
if(this.k14 == "丙" && this.k21 == "子"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k21 == "丑"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k21 == "申"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k21 == "酉"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k21 == "辰"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k21 == "巳"){
    countWater = countWater + 1;
}
if(this.k14 == "丙" && this.k21 == "午"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k21 == "未"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k21 == "寅"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k21 == "卯"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k21 == "戌"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k21 == "亥"){
    countWater = countWater + 1;
}
   
   
   
   //(1)K14和K22
if(this.k14 == "丙" && this.k22 == "子"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k22 == "丑"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k22 == "申"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k22 == "酉"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k22 == "辰"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k22 == "巳"){
    countWater = countWater + 1;
}
if(this.k14 == "丙" && this.k22 == "午"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k22 == "未"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k22 == "寅"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k22 == "卯"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k22 == "戌"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k22 == "亥"){
    countWater = countWater + 1;
}


        //(1)K14和K23
if(this.k14 == "丙" && this.k23 == "子"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k23 == "丑"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k23 == "申"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k23 == "酉"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k23 == "辰"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k23 == "巳"){
    countWater = countWater + 1;
}
if(this.k14 == "丙" && this.k23 == "午"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k23 == "未"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k23 == "寅"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k23 == "卯"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k23 == "戌"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k23 == "亥"){
    countWater = countWater + 1;
}



         //(1)K14和K24
if(this.k14 == "丙" && this.k24 == "子"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k24 == "丑"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k24 == "申"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k24 == "酉"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k24 == "辰"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k24 == "巳"){
    countWater = countWater + 1;
}
if(this.k14 == "丙" && this.k24 == "午"){
    countWater = countWater + 1;
}
if(this.k14 == "丁" && this.k24 == "未"){
    countWater = countWater + 1;
}
if(this.k14 == "甲" && this.k24 == "寅"){
    countWater = countWater + 1;
}
if(this.k14 == "乙" && this.k24 == "卯"){
    countWater = countWater + 1;
}
if(this.k14 == "壬" && this.k24 == "戌"){
    countWater = countWater + 1;
}
if(this.k14 == "癸" && this.k24 == "亥"){
    countWater = countWater + 1;
}




      let countFire = 0;
      //火fire
      //1.判断天干K11-K14
      if (this.k11 == "丙" || this.k11 == "丁") {
        countFire = countFire + 1;
      }
      if (this.k12 == "丙" || this.k12 == "丁") {
        countFire = countFire + 1;
      }
      if (this.k13 == "丙" || this.k13 == "丁") {
        countFire = countFire + 1;
      }
      if (this.k14 == "丙" || this.k14 == "丁") {
        countFire = countFire + 1;
      }
      //2.判断月柱地支K22
      if (this.k22 == "巳" || this.k22 == "午") {
        countFire = countFire + 0.5;
      }
      //3.地支藏干K31-K34
      if (this.k31.match("丙")) {
        countFire = countFire + 1;
      }
            if (this.k31.match("丁")) {
        countFire = countFire + 1;
      }
            if (this.k32.match("丙")) {
        countFire = countFire + 1;
      }
            if (this.k32.match("丁")) {
        countFire = countFire + 1;
      }
                  if (this.k33.match("丙")) {
        countFire = countFire + 1;
      }
            if (this.k33.match("丁")) {
        countFire = countFire + 1;
      }
                  if (this.k34.match("丙")) {
        countFire = countFire + 1;
      }
            if (this.k34.match("丁")) {
        countFire = countFire + 1;
      }

      //4.天干化合K11跟K32化，K12跟K31、K33化，K13跟K32、K34化，K14跟K33化
              //(1)K11跟K32化 
      if(this.k32.match("癸") && !this.k32.match("戊")){
      let guiArray = this.k32.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k11 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k11 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k11 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k11 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k11 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k32.match("癸") && this.k32.match("戊")){
          let guiArray = this.k32.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k32.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k11 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k11 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k11 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k11 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k11 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k11 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k11 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k11 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k11 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k11 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k11 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }

      //(2)K12跟K31、K33化 
      //(一)K12跟K31
if(this.k31.match("癸") && !this.k31.match("戊")){
      let guiArray = this.k31.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k12 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k12 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k12 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k31.match("癸") && this.k31.match("戊")){
          let guiArray = this.k31.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k31.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k12 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }

      //(二)K12跟K33
if(this.k33.match("癸") && !this.k33.match("戊")){
      let guiArray = this.k33.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k12 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k12 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k12 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k33.match("癸") && this.k33.match("戊")){
          let guiArray = this.k33.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k33.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k12 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k12 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k12 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }
      //(3)K13跟K32、K34化
            //(一)K13跟K32
if(this.k32.match("癸") && !this.k32.match("戊")){
      let guiArray = this.k32.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k13 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k13 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k13 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k32.match("癸") && this.k32.match("戊")){
          let guiArray = this.k32.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k32.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k13 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }

      //(二)K13跟K34
if(this.k34.match("癸") && !this.k34.match("戊")){
      let guiArray = this.k34.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k13 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k13 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k13 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k34.match("癸") && this.k34.match("戊")){
          let guiArray = this.k34.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k34.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k13 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k13 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k13 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }

//(4)K14跟K33化
if(this.k33.match("癸") && !this.k33.match("戊")){
      let guiArray = this.k33.split("癸");
      let guiNum = guiArray.length - 1;
      if (this.k14 == "戊" && guiNum == 1) {
        countFire = countFire + 2;
      }else if(this.k14 == "戊" && guiNum == 2){
countFire = countFire + 3;
      }else if(this.k14 == "戊" && guiNum == 3){
countFire = countFire + 4;
      }else if(this.k14 == "戊" && guiNum == 4){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 5){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 6){
countFire = countFire + 7;
      }else if(this.k14 == "戊" && guiNum == 7){
countFire = countFire + 8;
      }
      }else if(this.k33.match("癸") && this.k33.match("戊")){
          let guiArray = this.k33.split("癸");
      let guiNum = guiArray.length - 1;
      let xuArray = this.k33.split("戊");
      let xuNum = xuArray.length - 1;

      if (this.k14 == "戊" && guiNum == 6 && xuNum == 1) {
        countFire = countFire + 8;
      }else if(this.k14 == "戊" && guiNum == 5 && xuNum == 1){
countFire = countFire + 7;
      }else if(this.k14 == "戊" && guiNum == 4 && xuNum == 1){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 3 && xuNum == 1){
countFire = countFire + 5;
      }else if(this.k14 == "戊" && guiNum == 2 && xuNum == 1){
countFire = countFire + 4;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 1){
countFire = countFire + 3;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 2){
countFire = countFire + 4;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 3){
countFire = countFire + 5;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 4){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 5){
countFire = countFire + 7;
      }else if(this.k14 == "戊" && guiNum == 1 && xuNum == 6){
countFire = countFire + 8;
      }else if(this.k14 == "戊" && guiNum == 2 && xuNum == 5){
countFire = countFire + 8;
      }else if(this.k14 == "戊" && guiNum == 3 && xuNum == 4){
countFire = countFire + 8;
      }else if(this.k14 == "戊" && guiNum == 2 && xuNum == 4){
countFire = countFire + 7;
      }else if(this.k14 == "戊" && guiNum == 2 && xuNum == 3){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 3 && xuNum == 2){
countFire = countFire + 6;
      }else if(this.k14 == "戊" && guiNum == 4 && xuNum == 3){
countFire = countFire + 8;
      }else if(this.k14 == "戊" && guiNum == 2 && xuNum == 2){
countFire = countFire + 5;
      }


      }

       //5.判断地支六合
      
      if(DiZhiLiuHe.match("卯") && DiZhiLiuHe.match("戌")){
          let maoArrayDiZhiLiuHe = DiZhiLiuHe.split("卯");
          let maoNumDiZhiLiuHe = maoArrayDiZhiLiuHe.length - 1;
          let xuArrayDiZhiLiuHe = DiZhiLiuHe.split("戌");
          let xuNumDiZhiLiuHe = xuArrayDiZhiLiuHe.length - 1;
          if(maoNumDiZhiLiuHe == 1 && xuNumDiZhiLiuHe == 1){
              countFire = countFire + 1;
          }else if(maoNumDiZhiLiuHe == 1 && xuNumDiZhiLiuHe == 2){
              countFire = countFire + 2;
          }else if(maoNumDiZhiLiuHe == 1 && xuNumDiZhiLiuHe == 3){
              countFire = countFire + 3;
          }else if(maoNumDiZhiLiuHe == 2 && xuNumDiZhiLiuHe == 1){
              countFire = countFire + 2;
          }else if(maoNumDiZhiLiuHe == 3 && xuNumDiZhiLiuHe == 1){
              countFire = countFire + 3;
          }else if(maoNumDiZhiLiuHe == 2 && xuNumDiZhiLiuHe == 2){
              countFire = countFire + 4;
          }
      }

      //6.判断生地半合
      if(ShengDiBanHe.match("寅") && ShengDiBanHe.match("午")){
          let yinArrayShengDiBanHe = ShengDiBanHe.split("寅");
          let yinNumShengDiBanHe = yinArrayShengDiBanHe.length - 1;
          let wuArrayShengDiBanHe = ShengDiBanHe.split("午");
          let wuNumShengDiBanHe = wuArrayShengDiBanHe.length - 1;
          if(yinNumShengDiBanHe == 1 && wuNumShengDiBanHe == 1){
              countFire = countFire + 1;
          }else if(shenNumDiZhiLiuHe == 1 && wuNumShengDiBanHe == 2){
              countFire = countFire + 2;
          }else if(shenNumDiZhiLiuHe == 1 && wuNumShengDiBanHe == 3){
              countFire = countFire + 3;
          }else if(shenNumDiZhiLiuHe == 2 && wuNumShengDiBanHe == 1){
              countFire = countFire + 2;
          }else if(shenNumDiZhiLiuHe == 3 && wuNumShengDiBanHe == 1){
              countFire = countFire + 3;
          }else if(shenNumDiZhiLiuHe == 2 && wuNumShengDiBanHe == 2){
              countFire = countFire + 4;
          }
      }

      //7.判断墓地半合
      if(MuDiBanHe.match("午") && MuDiBanHe.match("戌")){
          let wuArrayMuDiBanHe = MuDiBanHe.split("午");
          let wuNumMuDiBanHe = wuArrayMuDiBanHe.length - 1;
          let xuArrayMuDiBanHe = MuDiBanHe.split("戌");
          let xuNumMuDiBanHe = xuArrayMuDiBanHe.length - 1;
          if(wuNumMuDiBanHe == 1 && xuNumMuDiBanHe == 1){
              countFire = countFire + 1;
          }else if(shenNumDiZhiLiuHe == 1 && xuNumMuDiBanHe == 2){
              countFire = countFire + 2;
          }else if(shenNumDiZhiLiuHe == 1 && xuNumMuDiBanHe == 3){
              countFire = countFire + 3;
          }else if(shenNumDiZhiLiuHe == 2 && xuNumMuDiBanHe == 1){
              countFire = countFire + 2;
          }else if(shenNumDiZhiLiuHe == 3 && xuNumMuDiBanHe == 1){
              countFire = countFire + 3;
          }else if(shenNumDiZhiLiuHe == 2 && xuNumMuDiBanHe == 2){
              countFire = countFire + 4;
          }
      }

      //8.判断地支三合
      if(DiZhiSanHe.match("寅") && DiZhiSanHe.match("午") && DiZhiSanHe.match("戌")){
          let yinArrayDiZhiSanHe = DiZhiSanHe.split("寅");
          let yinNumDiZhiSanHe = yinArrayDiZhiSanHe.length - 1;
          let wuArrayDiZhiSanHe = DiZhiSanHe.split("午");
          let wuNumDiZhiSanHe = wuArrayDiZhiSanHe.length - 1;
          let xuArrayDiZhiSanHe = DiZhiSanHe.split("戌");
          let xuNumDiZhiSanHe = xuArrayDiZhiSanHe.length - 1;
          if(yinNumDiZhiSanHe == 1 && wuNumDiZhiSanHe == 1 && xuNumDiZhiSanHe == 1){
              countFire = countFire + 2;
          }else if(yinNumDiZhiSanHe == 1 && wuNumDiZhiSanHe == 1 && xuNumDiZhiSanHe == 2){
              countFire = countFire + 3;
          }else if(yinNumDiZhiSanHe == 1 && wuNumDiZhiSanHe == 2 && xuNumDiZhiSanHe == 2){
              countFire = countFire + 3;
          }else if(yinNumDiZhiSanHe == 2 && wuNumDiZhiSanHe == 1 && xuNumDiZhiSanHe == 1){
              countFire = countFire + 3;
          }
      }

      //9.三个地支
      if(SanGeDiZhi.match("巳")){
          let siArraySanGeDiZhi = SanGeDiZhi.split("巳");
          let siNumSanGeDiZhi = siArraySanGeDiZhi.length - 1;
          
          if(siNumSanGeDiZhi == 3){
              countFire = countFire + 3;
          }
      }
      if(SanGeDiZhi.match("午")){
          let wuArraySanGeDiZhi = SanGeDiZhi.split("午");
          let wuNumSanGeDiZhi = wuArraySanGeDiZhi.length - 1;
          
          if(wuNumSanGeDiZhi == 3){
              countFire = countFire + 3;
          }
      }
      
      //10.判断地支三会
      
      if(DiZhiSanHui.match("巳") && DiZhiSanHui.match("午") && DiZhiSanHui.match("未")){
          let siArrayDiZhiSanHui = DiZhiSanHui.split("巳");
          let siNumDiZhiSanHui = siArrayDiZhiSanHui.length - 1;
          let wuArrayDiZhiSanHui = DiZhiSanHui.split("午");
          let wuNumDiZhiSanHui = wuArrayDiZhiSanHui.length - 1;
          let weiArrayDiZhiSanHui = DiZhiSanHui.split("未");
          let weiNumDiZhiSanHui = weiArrayDiZhiSanHui.length - 1;
          if(siNumDiZhiSanHui == 1 && wuNumDiZhiSanHui == 1 && weiNumDiZhiSanHui == 1){
              countFire = countFire + 3;
          }else if(siNumDiZhiSanHui == 1 && wuNumDiZhiSanHui == 1 && weiNumDiZhiSanHui == 2){
              countFire = countFire + 3;
          }else if(siNumDiZhiSanHui == 1 && wuNumDiZhiSanHui == 2 && weiNumDiZhiSanHui == 2){
              countFire = countFire + 3;
          }else if(siNumDiZhiSanHui == 2 && wuNumDiZhiSanHui == 1 && weiNumDiZhiSanHui == 1){
              countFire = countFire + 3;
          }
      }

//11.判断四柱纳音K11-K14与K21-K24两两组合
      //(1)K11和K21
if(this.k11 == "甲" && this.k21 == "戌"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k21 == "亥"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k21 == "子"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k21 == "丑"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k21 == "申"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k21 == "酉"){
    countFire = countFire + 1;
}
if(this.k11 == "甲" && this.k21 == "辰"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k21 == "巳"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k21 == "午"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k21 == "未"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k21 == "寅"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k21 == "卯"){
    countFire = countFire + 1;
}



       //(1)K11和K22
if(this.k11 == "甲" && this.k22 == "戌"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k22 == "亥"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k22 == "子"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k22 == "丑"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k22 == "申"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k22 == "酉"){
    countFire = countFire + 1;
}
if(this.k11 == "甲" && this.k22 == "辰"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k22 == "巳"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k22 == "午"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k22 == "未"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k22 == "寅"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k22 == "卯"){
    countFire = countFire + 1;
}




        //(1)K11和K23
if(this.k11 == "甲" && this.k23 == "戌"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k23 == "亥"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k23 == "子"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k23 == "丑"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k23 == "申"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k23 == "酉"){
    countFire = countFire + 1;
}
if(this.k11 == "甲" && this.k23 == "辰"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k23 == "巳"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k23 == "午"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k23 == "未"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k23 == "寅"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k23 == "卯"){
    countFire = countFire + 1;
}




         //(1)K11和K24
if(this.k11 == "甲" && this.k24 == "戌"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k24 == "亥"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k24 == "子"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k24 == "丑"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k24 == "申"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k24 == "酉"){
    countFire = countFire + 1;
}
if(this.k11 == "甲" && this.k24 == "辰"){
    countFire = countFire + 1;
}
if(this.k11 == "乙" && this.k24 == "巳"){
    countFire = countFire + 1;
}
if(this.k11 == "戊" && this.k24 == "午"){
    countFire = countFire + 1;
}
if(this.k11 == "己" && this.k24 == "未"){
    countFire = countFire + 1;
}
if(this.k11 == "丙" && this.k24 == "寅"){
    countFire = countFire + 1;
}
if(this.k11 == "丁" && this.k24 == "卯"){
    countFire = countFire + 1;
}




                //(1)K12和K21
if(this.k12 == "甲" && this.k21 == "戌"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k21 == "亥"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k21 == "子"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k21 == "丑"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k21 == "申"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k21 == "酉"){
    countFire = countFire + 1;
}
if(this.k12 == "甲" && this.k21 == "辰"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k21 == "巳"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k21 == "午"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k21 == "未"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k21 == "寅"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k21 == "卯"){
    countFire = countFire + 1;
}



       //(1)K12和K22
if(this.k12 == "甲" && this.k22 == "戌"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k22 == "亥"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k22 == "子"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k22 == "丑"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k22 == "申"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k22 == "酉"){
    countFire = countFire + 1;
}
if(this.k12 == "甲" && this.k22 == "辰"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k22 == "巳"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k22 == "午"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k22 == "未"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k22 == "寅"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k22 == "卯"){
    countFire = countFire + 1;
}



        //(1)K12和K23
if(this.k12 == "甲" && this.k23 == "戌"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k23 == "亥"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k23 == "子"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k23 == "丑"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k23 == "申"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k23 == "酉"){
    countFire = countFire + 1;
}
if(this.k12 == "甲" && this.k23 == "辰"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k23 == "巳"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k23 == "午"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k23 == "未"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k23 == "寅"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k23 == "卯"){
    countFire = countFire + 1;
}



         //(1)K12和K24
if(this.k12 == "甲" && this.k24 == "戌"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k24 == "亥"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k24 == "子"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k24 == "丑"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k24 == "申"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k24 == "酉"){
    countFire = countFire + 1;
}
if(this.k12 == "甲" && this.k24 == "辰"){
    countFire = countFire + 1;
}
if(this.k12 == "乙" && this.k24 == "巳"){
    countFire = countFire + 1;
}
if(this.k12 == "戊" && this.k24 == "午"){
    countFire = countFire + 1;
}
if(this.k12 == "己" && this.k24 == "未"){
    countFire = countFire + 1;
}
if(this.k12 == "丙" && this.k24 == "寅"){
    countFire = countFire + 1;
}
if(this.k12 == "丁" && this.k24 == "卯"){
    countFire = countFire + 1;
}


                         //(1)K13和K21
if(this.k13 == "甲" && this.k21 == "戌"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k21 == "亥"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k21 == "子"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k21 == "丑"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k21 == "申"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k21 == "酉"){
    countFire = countFire + 1;
}
if(this.k13 == "甲" && this.k21 == "辰"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k21 == "巳"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k21 == "午"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k21 == "未"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k21 == "寅"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k21 == "卯"){
    countFire = countFire + 1;
}




       //(1)K13和K22
if(this.k13 == "甲" && this.k22 == "戌"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k22 == "亥"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k22 == "子"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k22 == "丑"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k22 == "申"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k22 == "酉"){
    countFire = countFire + 1;
}
if(this.k13 == "甲" && this.k22 == "辰"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k22 == "巳"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k22 == "午"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k22 == "未"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k22 == "寅"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k22 == "卯"){
    countFire = countFire + 1;
}



        //(1)K13和K23
if(this.k13 == "甲" && this.k23 == "戌"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k23 == "亥"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k23 == "子"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k23 == "丑"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k23 == "申"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k23 == "酉"){
    countFire = countFire + 1;
}
if(this.k13 == "甲" && this.k23 == "辰"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k23 == "巳"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k23 == "午"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k23 == "未"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k23 == "寅"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k23 == "卯"){
    countFire = countFire + 1;
}



         //(1)K13和K24
if(this.k13 == "甲" && this.k24 == "戌"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k24 == "亥"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k24 == "子"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k24 == "丑"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k24 == "申"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k24 == "酉"){
    countFire = countFire + 1;
}
if(this.k13 == "甲" && this.k24 == "辰"){
    countFire = countFire + 1;
}
if(this.k13 == "乙" && this.k24 == "巳"){
    countFire = countFire + 1;
}
if(this.k13 == "戊" && this.k24 == "午"){
    countFire = countFire + 1;
}
if(this.k13 == "己" && this.k24 == "未"){
    countFire = countFire + 1;
}
if(this.k13 == "丙" && this.k24 == "寅"){
    countFire = countFire + 1;
}
if(this.k13 == "丁" && this.k24 == "卯"){
    countFire = countFire + 1;
}



                                //(1)K14和K21
if(this.k14 == "甲" && this.k21 == "戌"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k21 == "亥"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k21 == "子"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k21 == "丑"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k21 == "申"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k21 == "酉"){
    countFire = countFire + 1;
}
if(this.k14 == "甲" && this.k21 == "辰"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k21 == "巳"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k21 == "午"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k21 == "未"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k21 == "寅"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k21 == "卯"){
    countFire = countFire + 1;
}
   
   
   
   //(1)K14和K22
if(this.k14 == "甲" && this.k22 == "戌"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k22 == "亥"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k22 == "子"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k22 == "丑"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k22 == "申"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k22 == "酉"){
    countFire = countFire + 1;
}
if(this.k14 == "甲" && this.k22 == "辰"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k22 == "巳"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k22 == "午"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k22 == "未"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k22 == "寅"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k22 == "卯"){
    countFire = countFire + 1;
}


        //(1)K14和K23
if(this.k14 == "甲" && this.k23 == "戌"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k23 == "亥"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k23 == "子"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k23 == "丑"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k23 == "申"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k23 == "酉"){
    countFire = countFire + 1;
}
if(this.k14 == "甲" && this.k23 == "辰"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k23 == "巳"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k23 == "午"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k23 == "未"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k23 == "寅"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k23 == "卯"){
    countFire = countFire + 1;
}



         //(1)K14和K24
if(this.k14 == "甲" && this.k24 == "戌"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k24 == "亥"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k24 == "子"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k24 == "丑"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k24 == "申"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k24 == "酉"){
    countFire = countFire + 1;
}
if(this.k14 == "甲" && this.k24 == "辰"){
    countFire = countFire + 1;
}
if(this.k14 == "乙" && this.k24 == "巳"){
    countFire = countFire + 1;
}
if(this.k14 == "戊" && this.k24 == "午"){
    countFire = countFire + 1;
}
if(this.k14 == "己" && this.k24 == "未"){
    countFire = countFire + 1;
}
if(this.k14 == "丙" && this.k24 == "寅"){
    countFire = countFire + 1;
}
if(this.k14 == "丁" && this.k24 == "卯"){
    countFire = countFire + 1;
}




      let countTree = 0;
      //木Tree
      //1.判断天干K11-K14
      if (this.k11 == "甲" || this.k11 == "乙") {
        countTree = countTree + 1;
      }
      if (this.k12 == "甲" || this.k12 == "乙") {
        countTree = countTree + 1;
      }
      if (this.k13 == "甲" || this.k13 == "乙") {
        countTree = countTree + 1;
      }
      if (this.k14 == "甲" || this.k14 == "乙") {
        countTree = countTree + 1;
      }
      //2.判断月柱地支K22
      if (this.k22 == "寅" || this.k22 == "卯") {
        countTree = countTree + 0.5;
      }
      //3.地支藏干K31-K34
      if (this.k31.match("甲")) {
        countTree = countTree + 1;
      }
            if (this.k31.match("乙")) {
        countTree = countTree + 1;
      }
            if (this.k32.match("甲")) {
        countTree = countTree + 1;
      }
            if (this.k32.match("乙")) {
        countTree = countTree + 1;
      }
                  if (this.k33.match("甲")) {
        countTree = countTree + 1;
      }
            if (this.k33.match("乙")) {
        countTree = countTree + 1;
      }
                  if (this.k34.match("甲")) {
        countTree = countTree + 1;
      }
            if (this.k34.match("乙")) {
        countTree = countTree + 1;
      }

       //4.天干化合K11跟K32化，K12跟K31、K33化，K13跟K32、K34化，K14跟K33化
              //(1)K11跟K32化 
      if(this.k32.match("壬") && !this.k32.match("丁")){
      let renArray = this.k32.split("壬");
      let renNum = renArray.length - 1;
      if (this.k11 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k11 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k11 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k11 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k11 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k32.match("壬") && this.k32.match("丁")){
          let renArray = this.k32.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k32.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k11 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k11 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k11 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k11 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k11 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k11 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k11 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k11 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k11 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k11 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k11 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }

      //(2)K12跟K31、K33化 
      //(一)K12跟K31
if(this.k31.match("壬") && !this.k31.match("丁")){
      let renArray = this.k31.split("壬");
      let renNum = renArray.length - 1;
      if (this.k12 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k12 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k12 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k31.match("壬") && this.k31.match("丁")){
          let renArray = this.k31.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k31.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k12 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }

      //(二)K12跟K33
if(this.k33.match("壬") && !this.k33.match("丁")){
      let renArray = this.k33.split("壬");
      let renNum = renArray.length - 1;
      if (this.k12 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k12 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k12 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k33.match("壬") && this.k33.match("丁")){
          let renArray = this.k33.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k33.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k12 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k12 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k12 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }
      //(3)K13跟K32、K34化
            //(一)K13跟K32
if(this.k32.match("壬") && !this.k32.match("丁")){
      let renArray = this.k32.split("壬");
      let renNum = renArray.length - 1;
      if (this.k13 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k13 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k13 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k32.match("壬") && this.k32.match("丁")){
          let renArray = this.k32.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k32.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k13 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }

      //(二)K13跟K34
if(this.k34.match("壬") && !this.k34.match("丁")){
      let renArray = this.k34.split("壬");
      let renNum = renArray.length - 1;
      if (this.k13 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k13 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k13 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k34.match("壬") && this.k34.match("丁")){
          let renArray = this.k34.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k34.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k13 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k13 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k13 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }

//(4)K14跟K33化
      if(this.k33.match("壬") && !this.k33.match("丁")){
      let renArray = this.k33.split("壬");
      let renNum = renArray.length - 1;
      if (this.k14 == "丁" && renNum == 1) {
        countTree = countTree + 2;
      }else if(this.k14 == "丁" && renNum == 2){
countTree = countTree + 3;
      }else if(this.k14 == "丁" && renNum == 3){
countTree = countTree + 4;
      }else if(this.k14 == "丁" && renNum == 4){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 5){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 6){
countTree = countTree + 7;
      }else if(this.k14 == "丁" && renNum == 7){
countTree = countTree + 8;
      }
      }else if(this.k33.match("壬") && this.k33.match("丁")){
          let renArray = this.k33.split("壬");
      let renNum = renArray.length - 1;
      let dingArray = this.k33.split("丁");
      let dingNum = dingArray.length - 1;

      if (this.k14 == "丁" && renNum == 6 && dingNum == 1) {
        countTree = countTree + 8;
      }else if(this.k14 == "丁" && renNum == 5 && dingNum == 1){
countTree = countTree + 7;
      }else if(this.k14 == "丁" && renNum == 4 && dingNum == 1){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 3 && dingNum == 1){
countTree = countTree + 5;
      }else if(this.k14 == "丁" && renNum == 2 && dingNum == 1){
countTree = countTree + 4;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 1){
countTree = countTree + 3;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 2){
countTree = countTree + 4;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 3){
countTree = countTree + 5;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 4){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 5){
countTree = countTree + 7;
      }else if(this.k14 == "丁" && renNum == 1 && dingNum == 6){
countTree = countTree + 8;
      }else if(this.k14 == "丁" && renNum == 2 && dingNum == 5){
countTree = countTree + 8;
      }else if(this.k14 == "丁" && renNum == 3 && dingNum == 4){
countTree = countTree + 8;
      }else if(this.k14 == "丁" && renNum == 2 && dingNum == 4){
countTree = countTree + 7;
      }else if(this.k14 == "丁" && renNum == 2 && dingNum == 3){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 3 && dingNum == 2){
countTree = countTree + 6;
      }else if(this.k14 == "丁" && renNum == 4 && dingNum == 3){
countTree = countTree + 8;
      }else if(this.k14 == "丁" && renNum == 2 && dingNum == 2){
countTree = countTree + 5;
      }

     


      }

      //5.判断地支六合
      
      if(DiZhiLiuHe.match("寅") && DiZhiLiuHe.match("亥")){
          let yinArrayDiZhiLiuHe = DiZhiLiuHe.split("寅");
          let yinNumDiZhiLiuHe = yinArrayDiZhiLiuHe.length - 1;
          let haiArrayDiZhiLiuHe = DiZhiLiuHe.split("亥");
          let haiNumDiZhiLiuHe = haiArrayDiZhiLiuHe.length - 1;
          if(yinNumDiZhiLiuHe == 1 && haiNumDiZhiLiuHe == 1){
              countTree = countTree + 1;
          }else if(yinNumDiZhiLiuHe == 1 && haiNumDiZhiLiuHe == 2){
              countTree = countTree + 2;
          }else if(yinNumDiZhiLiuHe == 1 && haiNumDiZhiLiuHe == 3){
              countTree = countTree + 3;
          }else if(yinNumDiZhiLiuHe == 2 && haiNumDiZhiLiuHe == 1){
              countTree = countTree + 2;
          }else if(yinNumDiZhiLiuHe == 3 && haiNumDiZhiLiuHe == 1){
              countTree = countTree + 3;
          }else if(yinNumDiZhiLiuHe == 2 && haiNumDiZhiLiuHe == 2){
              countTree = countTree + 4;
          }
      }

       //6.判断生地半合
      if(ShengDiBanHe.match("亥") && ShengDiBanHe.match("卯")){
          let haiArrayShengDiBanHe = ShengDiBanHe.split("亥");
          let haiNumShengDiBanHe = haiArrayShengDiBanHe.length - 1;
          let maoArrayShengDiBanHe = ShengDiBanHe.split("卯");
          let maoNumShengDiBanHe = maoArrayShengDiBanHe.length - 1;
          if(haiNumShengDiBanHe == 1 && maoNumShengDiBanHe == 1){
              countTree = countTree + 1;
          }else if(shenNumDiZhiLiuHe == 1 && maoNumShengDiBanHe == 2){
              countTree = countTree + 2;
          }else if(shenNumDiZhiLiuHe == 1 && maoNumShengDiBanHe == 3){
              countTree = countTree + 3;
          }else if(shenNumDiZhiLiuHe == 2 && maoNumShengDiBanHe == 1){
              countTree = countTree + 2;
          }else if(shenNumDiZhiLiuHe == 3 && maoNumShengDiBanHe == 1){
              countTree = countTree + 3;
          }else if(shenNumDiZhiLiuHe == 2 && maoNumShengDiBanHe == 2){
              countTree = countTree + 4;
          }
      }

      //7.判断墓地半合
      if(MuDiBanHe.match("卯") && MuDiBanHe.match("未")){
          let maoArrayMuDiBanHe = MuDiBanHe.split("卯");
          let maoNumMuDiBanHe = maoArrayMuDiBanHe.length - 1;
          let weiArrayMuDiBanHe = MuDiBanHe.split("未");
          let weiNumMuDiBanHe = weiArrayMuDiBanHe.length - 1;
          if(maoNumMuDiBanHe == 1 && weiNumMuDiBanHe == 1){
              countTree = countTree + 1;
          }else if(shenNumDiZhiLiuHe == 1 && weiNumMuDiBanHe == 2){
              countTree = countTree + 2;
          }else if(shenNumDiZhiLiuHe == 1 && weiNumMuDiBanHe == 3){
              countTree = countTree + 3;
          }else if(shenNumDiZhiLiuHe == 2 && weiNumMuDiBanHe == 1){
              countTree = countTree + 2;
          }else if(shenNumDiZhiLiuHe == 3 && weiNumMuDiBanHe == 1){
              countTree = countTree + 3;
          }else if(shenNumDiZhiLiuHe == 2 && weiNumMuDiBanHe == 2){
              countTree = countTree + 4;
          }
      }

//8.判断地支三合
      if(DiZhiSanHe.match("亥") && DiZhiSanHe.match("卯") && DiZhiSanHe.match("未")){
          let haiArrayDiZhiSanHe = DiZhiSanHe.split("亥");
          let haiNumDiZhiSanHe = haiArrayDiZhiSanHe.length - 1;
          let maoArrayDiZhiSanHe = DiZhiSanHe.split("卯");
          let maoNumDiZhiSanHe = maoArrayDiZhiSanHe.length - 1;
          let weiArrayDiZhiSanHe = DiZhiSanHe.split("未");
          let weiNumDiZhiSanHe = weiArrayDiZhiSanHe.length - 1;
          if(haiNumDiZhiSanHe == 1 && maoNumDiZhiSanHe == 1 && weiNumDiZhiSanHe == 1){
              countTree = countTree + 2;
          }else if(haiNumDiZhiSanHe == 1 && maoNumDiZhiSanHe == 1 && weiNumDiZhiSanHe == 2){
              countTree = countTree + 3;
          }else if(haiNumDiZhiSanHe == 1 && maoNumDiZhiSanHe == 2 && weiNumDiZhiSanHe == 2){
              countTree = countTree + 3;
          }else if(haiNumDiZhiSanHe == 2 && maoNumDiZhiSanHe == 1 && weiNumDiZhiSanHe == 1){
              countTree = countTree + 3;
          }
      }

      //9.三个地支
      if(SanGeDiZhi.match("寅")){
          let yinArraySanGeDiZhi = SanGeDiZhi.split("寅");
          let yinNumSanGeDiZhi = yinArraySanGeDiZhi.length - 1;
          
          if(yinNumSanGeDiZhi == 3){
              countTree = countTree + 3;
          }
      }
      if(SanGeDiZhi.match("卯")){
          let mouArraySanGeDiZhi = SanGeDiZhi.split("卯");
          let mouNumSanGeDiZhi = mouArraySanGeDiZhi.length - 1;
          
          if(mouNumSanGeDiZhi == 3){
              countTree = countTree + 3;
          }
      }


 //10.判断地支三会
      
      if(DiZhiSanHui.match("寅") && DiZhiSanHui.match("卯") && DiZhiSanHui.match("辰")){
          let yinArrayDiZhiSanHui = DiZhiSanHui.split("寅");
          let yinNumDiZhiSanHui = yinArrayDiZhiSanHui.length - 1;
          let maoArrayDiZhiSanHui = DiZhiSanHui.split("卯");
          let maoNumDiZhiSanHui = maoArrayDiZhiSanHui.length - 1;
          let chenArrayDiZhiSanHui = DiZhiSanHui.split("辰");
          let chenNumDiZhiSanHui = chenArrayDiZhiSanHui.length - 1;
          if(yinNumDiZhiSanHui == 1 && maoNumDiZhiSanHui == 1 && chenNumDiZhiSanHui == 1){
              countTree = countTree + 3;
          }else if(yinNumDiZhiSanHui == 1 && maoNumDiZhiSanHui == 1 && chenNumDiZhiSanHui == 2){
              countTree = countTree + 3;
          }else if(yinNumDiZhiSanHui == 1 && maoNumDiZhiSanHui == 2 && chenNumDiZhiSanHui == 2){
              countTree = countTree + 3;
          }else if(yinNumDiZhiSanHui == 2 && maoNumDiZhiSanHui == 1 && chenNumDiZhiSanHui == 1){
              countTree = countTree + 3;
          }
      }

      //11.判断四柱纳音K11-K14与K21-K24两两组合
      //(1)K11和K21
if(this.k11 == "戊" && this.k21 == "辰"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k21 == "巳"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k21 == "午"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k21 == "未"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k21 == "寅"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k21 == "卯"){
    countTree = countTree + 1;
}
if(this.k11 == "戊" && this.k21 == "戌"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k21 == "亥"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k21 == "子"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k21 == "丑"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k21 == "申"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k21 == "酉"){
    countTree = countTree + 1;
}

//(1)K11和K22
if(this.k11 == "戊" && this.k22 == "辰"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k22 == "巳"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k22 == "午"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k22 == "未"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k22 == "寅"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k22 == "卯"){
    countTree = countTree + 1;
}
if(this.k11 == "戊" && this.k22 == "戌"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k22 == "亥"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k22 == "子"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k22 == "丑"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k22 == "申"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k22 == "酉"){
    countTree = countTree + 1;
}

//(1)K11和K23
if(this.k11 == "戊" && this.k23 == "辰"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k23 == "巳"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k23 == "午"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k23 == "未"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k23 == "寅"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k23 == "卯"){
    countTree = countTree + 1;
}
if(this.k11 == "戊" && this.k23 == "戌"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k23 == "亥"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k23 == "子"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k23 == "丑"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k23 == "申"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k23 == "酉"){
    countTree = countTree + 1;
}

//(1)K11和K24
if(this.k11 == "戊" && this.k24 == "辰"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k24 == "巳"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k24 == "午"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k24 == "未"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k24 == "寅"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k24 == "卯"){
    countTree = countTree + 1;
}
if(this.k11 == "戊" && this.k24 == "戌"){
    countTree = countTree + 1;
}
if(this.k11 == "己" && this.k24 == "亥"){
    countTree = countTree + 1;
}
if(this.k11 == "壬" && this.k24 == "子"){
    countTree = countTree + 1;
}
if(this.k11 == "癸" && this.k24 == "丑"){
    countTree = countTree + 1;
}
if(this.k11 == "庚" && this.k24 == "申"){
    countTree = countTree + 1;
}
if(this.k11 == "辛" && this.k24 == "酉"){
    countTree = countTree + 1;
}

//(1)K12和K21
if(this.k12 == "戊" && this.k21 == "辰"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k21 == "巳"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k21 == "午"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k21 == "未"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k21 == "寅"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k21 == "卯"){
    countTree = countTree + 1;
}
if(this.k12 == "戊" && this.k21 == "戌"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k21 == "亥"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k21 == "子"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k21 == "丑"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k21 == "申"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k21 == "酉"){
    countTree = countTree + 1;
}
//(1)K12和K22
if(this.k12 == "戊" && this.k22 == "辰"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k22 == "巳"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k22 == "午"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k22 == "未"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k22 == "寅"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k22 == "卯"){
    countTree = countTree + 1;
}
if(this.k12 == "戊" && this.k22 == "戌"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k22 == "亥"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k22 == "子"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k22 == "丑"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k22 == "申"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k22 == "酉"){
    countTree = countTree + 1;
}

//(1)K12和K23
if(this.k12 == "戊" && this.k23 == "辰"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k23 == "巳"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k23 == "午"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k23 == "未"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k23 == "寅"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k23 == "卯"){
    countTree = countTree + 1;
}
if(this.k12 == "戊" && this.k23 == "戌"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k23 == "亥"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k23 == "子"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k23 == "丑"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k23 == "申"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k23 == "酉"){
    countTree = countTree + 1;
}

//(1)K12和K24
if(this.k12 == "戊" && this.k24 == "辰"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k24 == "巳"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k24 == "午"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k24 == "未"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k24 == "寅"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k24 == "卯"){
    countTree = countTree + 1;
}
if(this.k12 == "戊" && this.k24 == "戌"){
    countTree = countTree + 1;
}
if(this.k12 == "己" && this.k24 == "亥"){
    countTree = countTree + 1;
}
if(this.k12 == "壬" && this.k24 == "子"){
    countTree = countTree + 1;
}
if(this.k12 == "癸" && this.k24 == "丑"){
    countTree = countTree + 1;
}
if(this.k12 == "庚" && this.k24 == "申"){
    countTree = countTree + 1;
}
if(this.k12 == "辛" && this.k24 == "酉"){
    countTree = countTree + 1;
}
//(1)K13和K21
if(this.k13 == "戊" && this.k21 == "辰"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k21 == "巳"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k21 == "午"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k21 == "未"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k21 == "寅"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k21 == "卯"){
    countTree = countTree + 1;
}
if(this.k13 == "戊" && this.k21 == "戌"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k21 == "亥"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k21 == "子"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k21 == "丑"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k21 == "申"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k21 == "酉"){
    countTree = countTree + 1;
}
//(1)K13和K22
if(this.k13 == "戊" && this.k22 == "辰"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k22 == "巳"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k22 == "午"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k22 == "未"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k22 == "寅"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k22 == "卯"){
    countTree = countTree + 1;
}
if(this.k13 == "戊" && this.k22 == "戌"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k22 == "亥"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k22 == "子"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k22 == "丑"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k22 == "申"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k22 == "酉"){
    countTree = countTree + 1;
}
//(1)K13和K23
if(this.k13 == "戊" && this.k23 == "辰"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k23 == "巳"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k23 == "午"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k23 == "未"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k23 == "寅"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k23 == "卯"){
    countTree = countTree + 1;
}
if(this.k13 == "戊" && this.k23 == "戌"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k23 == "亥"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k23 == "子"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k23 == "丑"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k23 == "申"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k23 == "酉"){
    countTree = countTree + 1;
}
//(1)K13和K24
if(this.k13 == "戊" && this.k24 == "辰"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k24 == "巳"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k24 == "午"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k24 == "未"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k24 == "寅"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k24 == "卯"){
    countTree = countTree + 1;
}
if(this.k13 == "戊" && this.k24 == "戌"){
    countTree = countTree + 1;
}
if(this.k13 == "己" && this.k24 == "亥"){
    countTree = countTree + 1;
}
if(this.k13 == "壬" && this.k24 == "子"){
    countTree = countTree + 1;
}
if(this.k13 == "癸" && this.k24 == "丑"){
    countTree = countTree + 1;
}
if(this.k13 == "庚" && this.k24 == "申"){
    countTree = countTree + 1;
}
if(this.k13 == "辛" && this.k24 == "酉"){
    countTree = countTree + 1;
}

//(1)K14和K21
if(this.k14 == "戊" && this.k21 == "辰"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k21 == "巳"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k21 == "午"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k21 == "未"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k21 == "寅"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k21 == "卯"){
    countTree = countTree + 1;
}
if(this.k14 == "戊" && this.k21 == "戌"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k21 == "亥"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k21 == "子"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k21 == "丑"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k21 == "申"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k21 == "酉"){
    countTree = countTree + 1;
}
//(1)K14和K22
if(this.k14 == "戊" && this.k22 == "辰"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k22 == "巳"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k22 == "午"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k22 == "未"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k22 == "寅"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k22 == "卯"){
    countTree = countTree + 1;
}
if(this.k14 == "戊" && this.k22 == "戌"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k22 == "亥"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k22 == "子"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k22 == "丑"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k22 == "申"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k22 == "酉"){
    countTree = countTree + 1;
}
//(1)K14和K23
if(this.k14 == "戊" && this.k23 == "辰"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k23 == "巳"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k23 == "午"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k23 == "未"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k23 == "寅"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k23 == "卯"){
    countTree = countTree + 1;
}
if(this.k14 == "戊" && this.k23 == "戌"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k23 == "亥"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k23 == "子"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k23 == "丑"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k23 == "申"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k23 == "酉"){
    countTree = countTree + 1;
}
//(1)K14和K23
if(this.k14 == "戊" && this.k24 == "辰"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k24 == "巳"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k24 == "午"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k24 == "未"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k24 == "寅"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k24 == "卯"){
    countTree = countTree + 1;
}
if(this.k14 == "戊" && this.k24 == "戌"){
    countTree = countTree + 1;
}
if(this.k14 == "己" && this.k24 == "亥"){
    countTree = countTree + 1;
}
if(this.k14 == "壬" && this.k24 == "子"){
    countTree = countTree + 1;
}
if(this.k14 == "癸" && this.k24 == "丑"){
    countTree = countTree + 1;
}
if(this.k14 == "庚" && this.k24 == "申"){
    countTree = countTree + 1;
}
if(this.k14 == "辛" && this.k24 == "酉"){
    countTree = countTree + 1;
}




      let countGold = 0;
      //金gold
      //1.判断天干K11-K14
      if (this.k11 == "庚" || this.k11 == "辛") {
        countGold = countGold + 1;
      }
      if (this.k12 == "庚" || this.k12 == "辛") {
        countGold = countGold + 1;
      }
      if (this.k13 == "庚" || this.k13 == "辛") {
        countGold = countGold + 1;
      }
      if (this.k14 == "庚" || this.k14 == "辛") {
        countGold = countGold + 1;
      }
      //2.判断月柱地支K22
      if (this.k22 == "申" || this.k22 == "酉") {
        countGold = countGold + 0.5;
      }
      //3.地支藏干K31-K34
      if (this.k31.match("庚")) {
        countGold = countGold + 1;
      }
            if (this.k31.match("辛")) {
        countGold = countGold + 1;
      }
            if (this.k32.match("庚")) {
        countGold = countGold + 1;
      }
            if (this.k32.match("辛")) {
        countGold = countGold + 1;
      }
                  if (this.k33.match("庚")) {
        countGold = countGold + 1;
      }
            if (this.k33.match("辛")) {
        countGold = countGold + 1;
      }
                  if (this.k34.match("庚")) {
        countGold = countGold + 1;
      }
            if (this.k34.match("辛")) {
        countGold = countGold + 1;
      }

       //4.天干化合K11跟K32化，K12跟K31、K33化，K13跟K32、K34化，K14跟K33化
           //(1)K11跟K32化   
      if(this.k32.match("庚") && !this.k32.match("乙")){
      let gengArray = this.k32.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k11 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k11 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k11 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k11 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k11 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k32.match("庚") && this.k32.match("乙")){
           let gengArray = this.k32.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k32.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k11 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k11 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k11 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k11 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k11 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k11 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k11 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k11 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k11 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k11 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k11 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }
      //(2)K12跟K31、K33化 
      //(一)K12跟K31
if(this.k31.match("庚") && !this.k31.match("乙")){
      let gengArray = this.k31.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k12 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k12 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k12 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k31.match("庚") && this.k31.match("乙")){
           let gengArray = this.k31.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k31.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k12 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }

      //(二)K12跟K33
if(this.k33.match("庚") && !this.k33.match("乙")){
      let gengArray = this.k33.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k12 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k12 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k12 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k33.match("庚") && this.k33.match("乙")){
           let gengArray = this.k33.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k33.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k12 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k12 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k12 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }
      //(3)K13跟K32、K34化
            //(一)K13跟K32
if(this.k32.match("庚") && !this.k32.match("乙")){
      let gengArray = this.k32.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k13 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k13 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k13 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k32.match("庚") && this.k32.match("乙")){
           let gengArray = this.k32.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k32.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k13 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }

      //(二)K13跟K34
if(this.k34.match("庚") && !this.k34.match("乙")){
      let gengArray = this.k34.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k13 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k13 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k13 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k34.match("庚") && this.k34.match("乙")){
           let gengArray = this.k34.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k34.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k13 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k13 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k13 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }


//(4)K14跟K33化
if(this.k33.match("庚") && !this.k33.match("乙")){
      let gengArray = this.k33.split("庚");
      let gengNum = gengArray.length - 1;
      if (this.k14 == "乙" && gengNum == 1) {
        countGold = countGold + 2;
      }else if(this.k14 == "乙" && gengNum == 2){
countGold = countGold + 3;
      }else if(this.k14 == "乙" && gengNum == 3){
countGold = countGold + 4;
      }else if(this.k14 == "乙" && gengNum == 4){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 5){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 6){
countGold = countGold + 7;
      }else if(this.k14 == "乙" && gengNum == 7){
countGold = countGold + 8;
      }
      }else if(this.k33.match("庚") && this.k33.match("乙")){
           let gengArray = this.k33.split("庚");
      let gengNum = gengArray.length - 1;
      let yiArray = this.k33.split("乙");
      let yiNum = yiArray.length - 1;

      if (this.k14 == "乙" && gengNum == 6 && yiNum == 1) {
        countGold = countGold + 8;
      }else if(this.k14 == "乙" && gengNum == 5 && yiNum == 1){
countGold = countGold + 7;
      }else if(this.k14 == "乙" && gengNum == 4 && yiNum == 1){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 3 && yiNum == 1){
countGold = countGold + 5;
      }else if(this.k14 == "乙" && gengNum == 2 && yiNum == 1){
countGold = countGold + 4;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 1){
countGold = countGold + 3;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 2){
countGold = countGold + 4;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 3){
countGold = countGold + 5;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 4){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 5){
countGold = countGold + 7;
      }else if(this.k14 == "乙" && gengNum == 1 && yiNum == 6){
countGold = countGold + 8;
      }else if(this.k14 == "乙" && gengNum == 2 && yiNum == 5){
countGold = countGold + 8;
      }else if(this.k14 == "乙" && gengNum == 3 && yiNum == 4){
countGold = countGold + 8;
      }else if(this.k14 == "乙" && gengNum == 2 && yiNum == 4){
countGold = countGold + 7;
      }else if(this.k14 == "乙" && gengNum == 2 && yiNum == 3){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 3 && yiNum == 2){
countGold = countGold + 6;
      }else if(this.k14 == "乙" && gengNum == 4 && yiNum == 3){
countGold = countGold + 8;
      }else if(this.k14 == "乙" && gengNum == 2 && yiNum == 2){
countGold = countGold + 5;
      }


      }

      //5.判断地支六合
      
      if(DiZhiLiuHe.match("辰") && DiZhiLiuHe.match("酉")){
          let chenArrayDiZhiLiuHe = DiZhiLiuHe.split("辰");
          let chenNumDiZhiLiuHe = chenArrayDiZhiLiuHe.length - 1;
          let youArrayDiZhiLiuHe = DiZhiLiuHe.split("酉");
          let youNumDiZhiLiuHe = youArrayDiZhiLiuHe.length - 1;
          if(chenNumDiZhiLiuHe == 1 && youNumDiZhiLiuHe == 1){
              countGold = countGold + 1;
          }else if(chenNumDiZhiLiuHe == 1 && youNumDiZhiLiuHe == 2){
              countGold = countGold + 2;
          }else if(chenNumDiZhiLiuHe == 1 && youNumDiZhiLiuHe == 3){
              countGold = countGold + 3;
          }else if(chenNumDiZhiLiuHe == 2 && youNumDiZhiLiuHe == 1){
              countGold = countGold + 2;
          }else if(chenNumDiZhiLiuHe == 3 && youNumDiZhiLiuHe == 1){
              countGold = countGold + 3;
          }else if(chenNumDiZhiLiuHe == 2 && youNumDiZhiLiuHe == 2){
              countGold = countGold + 4;
          }
      }

      //6.判断生地半合
      if(ShengDiBanHe.match("巳") && ShengDiBanHe.match("酉")){
          let jiArrayShengDiBanHe = ShengDiBanHe.split("巳");
          let jiNumShengDiBanHe = jiArrayShengDiBanHe.length - 1;
          let youArrayShengDiBanHe = ShengDiBanHe.split("酉");
          let youNumShengDiBanHe = youArrayShengDiBanHe.length - 1;
          if(jiNumShengDiBanHe == 1 && youNumShengDiBanHe == 1){
              countGold = countGold + 1;
          }else if(shenNumDiZhiLiuHe == 1 && youNumShengDiBanHe == 2){
              countGold = countGold + 2;
          }else if(shenNumDiZhiLiuHe == 1 && youNumShengDiBanHe == 3){
              countGold = countGold + 3;
          }else if(shenNumDiZhiLiuHe == 2 && youNumShengDiBanHe == 1){
              countGold = countGold + 2;
          }else if(shenNumDiZhiLiuHe == 3 && youNumShengDiBanHe == 1){
              countGold = countGold + 3;
          }else if(shenNumDiZhiLiuHe == 2 && youNumShengDiBanHe == 2){
              countGold = countGold + 4;
          }
      }

      //7.判断墓地半合
      if(MuDiBanHe.match("酉") && MuDiBanHe.match("丑")){
          let youArrayMuDiBanHe = MuDiBanHe.split("酉");
          let youNumMuDiBanHe = youArrayMuDiBanHe.length - 1;
          let chouArrayMuDiBanHe = MuDiBanHe.split("丑");
          let chouNumMuDiBanHe = chouArrayMuDiBanHe.length - 1;
          if(youNumMuDiBanHe == 1 && chouNumMuDiBanHe == 1){
              countGold = countGold + 1;
          }else if(shenNumDiZhiLiuHe == 1 && chouNumMuDiBanHe == 2){
              countGold = countGold + 2;
          }else if(shenNumDiZhiLiuHe == 1 && chouNumMuDiBanHe == 3){
              countGold = countGold + 3;
          }else if(shenNumDiZhiLiuHe == 2 && chouNumMuDiBanHe == 1){
              countGold = countGold + 2;
          }else if(shenNumDiZhiLiuHe == 3 && chouNumMuDiBanHe == 1){
              countGold = countGold + 3;
          }else if(shenNumDiZhiLiuHe == 2 && chouNumMuDiBanHe == 2){
              countGold = countGold + 4;
          }
      }

      //8.判断地支三合
      if(DiZhiSanHe.match("巳") && DiZhiSanHe.match("酉") && DiZhiSanHe.match("丑")){
          let siArrayDiZhiSanHe = DiZhiSanHe.split("巳");
          let siNumDiZhiSanHe = siArrayDiZhiSanHe.length - 1;
          let youArrayDiZhiSanHe = DiZhiSanHe.split("酉");
          let youNumDiZhiSanHe = youArrayDiZhiSanHe.length - 1;
          let chouArrayDiZhiSanHe = DiZhiSanHe.split("丑");
          let chouNumDiZhiSanHe = chouArrayDiZhiSanHe.length - 1;
          if(siNumDiZhiSanHe == 1 && youNumDiZhiSanHe == 1 && chouNumDiZhiSanHe == 1){
              countGold = countGold + 2;
          }else if(siNumDiZhiSanHe == 1 && youNumDiZhiSanHe == 1 && chouNumDiZhiSanHe == 2){
              countGold = countGold + 3;
          }else if(siNumDiZhiSanHe == 1 && youNumDiZhiSanHe == 2 && chouNumDiZhiSanHe == 2){
              countGold = countGold + 3;
          }else if(siNumDiZhiSanHe == 2 && youNumDiZhiSanHe == 1 && chouNumDiZhiSanHe == 1){
              countGold = countGold + 3;
          }
      }

      //9.三个地支
      if(SanGeDiZhi.match("申")){
          let shenArraySanGeDiZhi = SanGeDiZhi.split("申");
          let shenNumSanGeDiZhi = shenArraySanGeDiZhi.length - 1;
          
          if(shenNumSanGeDiZhi == 3){
              countGold = countGold + 3;
          }
      }
      if(SanGeDiZhi.match("酉")){
          let youArraySanGeDiZhi = SanGeDiZhi.split("酉");
          let youNumSanGeDiZhi = youArraySanGeDiZhi.length - 1;
          
          if(youNumSanGeDiZhi == 3){
              countGold = countGold + 3;
          }
      }

      //10.判断地支三会
      
      if(DiZhiSanHui.match("申") && DiZhiSanHui.match("酉") && DiZhiSanHui.match("戌")){
          let shenArrayDiZhiSanHui = DiZhiSanHui.split("申");
          let shenNumDiZhiSanHui = shenArrayDiZhiSanHui.length - 1;
          let youArrayDiZhiSanHui = DiZhiSanHui.split("酉");
          let youNumDiZhiSanHui = youArrayDiZhiSanHui.length - 1;
          let xuArrayDiZhiSanHui = DiZhiSanHui.split("戌");
          let xuNumDiZhiSanHui = xuArrayDiZhiSanHui.length - 1;
          if(shenNumDiZhiSanHui == 1 && youNumDiZhiSanHui == 1 && xuNumDiZhiSanHui == 1){
              countGold = countGold + 3;
          }else if(shenNumDiZhiSanHui == 1 && youNumDiZhiSanHui == 1 && xuNumDiZhiSanHui == 2){
              countGold = countGold + 3;
          }else if(shenNumDiZhiSanHui == 1 && youNumDiZhiSanHui == 2 && xuNumDiZhiSanHui == 2){
              countGold = countGold + 3;
          }else if(shenNumDiZhiSanHui == 2 && youNumDiZhiSanHui == 1 && xuNumDiZhiSanHui == 1){
              countGold = countGold + 3;
          }
      }

//11.判断四柱纳音
      //(1)K11和K21
if(this.k11 == "甲" && this.k21 == "子"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k21 == "丑"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k21 == "申"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k21 == "酉"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k21 == "辰"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k21 == "巳"){
    countGold = countGold + 1;
}
if(this.k11 == "甲" && this.k21 == "午"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k21 == "未"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k21 == "寅"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k21 == "卯"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k21 == "戌"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k21 == "亥"){
    countGold = countGold + 1;
}
//(1)K11和K22
if(this.k11 == "甲" && this.k22 == "子"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k22 == "丑"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k22 == "申"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k22 == "酉"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k22 == "辰"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k22 == "巳"){
    countGold = countGold + 1;
}
if(this.k11 == "甲" && this.k22 == "午"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k22 == "未"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k22 == "寅"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k22 == "卯"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k22 == "戌"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k22 == "亥"){
    countGold = countGold + 1;
}

//(1)K11和K23
if(this.k11 == "甲" && this.k23 == "子"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k23 == "丑"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k23 == "申"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k23 == "酉"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k23 == "辰"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k23 == "巳"){
    countGold = countGold + 1;
}
if(this.k11 == "甲" && this.k23 == "午"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k23 == "未"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k23 == "寅"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k23 == "卯"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k23 == "戌"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k23 == "亥"){
    countGold = countGold + 1;
}

//(1)K11和K24
if(this.k11 == "甲" && this.k24 == "子"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k24 == "丑"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k24 == "申"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k24 == "酉"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k24 == "辰"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k24 == "巳"){
    countGold = countGold + 1;
}
if(this.k11 == "甲" && this.k24 == "午"){
    countGold = countGold + 1;
}
if(this.k11 == "乙" && this.k24 == "未"){
    countGold = countGold + 1;
}
if(this.k11 == "壬" && this.k24 == "寅"){
    countGold = countGold + 1;
}
if(this.k11 == "癸" && this.k24 == "卯"){
    countGold = countGold + 1;
}
if(this.k11 == "庚" && this.k24 == "戌"){
    countGold = countGold + 1;
}
if(this.k11 == "辛" && this.k24 == "亥"){
    countGold = countGold + 1;
}

//(1)K12和K21
if(this.k12 == "甲" && this.k21 == "子"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k21 == "丑"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k21 == "申"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k21 == "酉"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k21 == "辰"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k21 == "巳"){
    countGold = countGold + 1;
}
if(this.k12 == "甲" && this.k21 == "午"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k21 == "未"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k21 == "寅"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k21 == "卯"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k21 == "戌"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k21 == "亥"){
    countGold = countGold + 1;
}

//(1)K12和K22
if(this.k12 == "甲" && this.k22 == "子"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k22 == "丑"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k22 == "申"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k22 == "酉"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k22 == "辰"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k22 == "巳"){
    countGold = countGold + 1;
}
if(this.k12 == "甲" && this.k22 == "午"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k22 == "未"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k22 == "寅"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k22 == "卯"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k22 == "戌"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k22 == "亥"){
    countGold = countGold + 1;
}

//(1)K12和K23
if(this.k12 == "甲" && this.k23 == "子"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k23 == "丑"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k23 == "申"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k23 == "酉"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k23 == "辰"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k23 == "巳"){
    countGold = countGold + 1;
}
if(this.k12 == "甲" && this.k23 == "午"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k23 == "未"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k23 == "寅"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k23 == "卯"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k23 == "戌"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k23 == "亥"){
    countGold = countGold + 1;
}

//(1)K12和K24
if(this.k12 == "甲" && this.k24 == "子"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k24 == "丑"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k24 == "申"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k24 == "酉"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k24 == "辰"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k24 == "巳"){
    countGold = countGold + 1;
}
if(this.k12 == "甲" && this.k24 == "午"){
    countGold = countGold + 1;
}
if(this.k12 == "乙" && this.k24 == "未"){
    countGold = countGold + 1;
}
if(this.k12 == "壬" && this.k24 == "寅"){
    countGold = countGold + 1;
}
if(this.k12 == "癸" && this.k24 == "卯"){
    countGold = countGold + 1;
}
if(this.k12 == "庚" && this.k24 == "戌"){
    countGold = countGold + 1;
}
if(this.k12 == "辛" && this.k24 == "亥"){
    countGold = countGold + 1;
}

//(1)K13和k21
if(this.k13 == "甲" && this.k21 == "子"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k21 == "丑"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k21 == "申"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k21 == "酉"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k21 == "辰"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k21 == "巳"){
    countGold = countGold + 1;
}
if(this.k13 == "甲" && this.k21 == "午"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k21 == "未"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k21 == "寅"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k21 == "卯"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k21 == "戌"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k21 == "亥"){
    countGold = countGold + 1;
}

//(1)K13和k22
if(this.k13 == "甲" && this.k22 == "子"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k22 == "丑"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k22 == "申"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k22 == "酉"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k22 == "辰"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k22 == "巳"){
    countGold = countGold + 1;
}
if(this.k13 == "甲" && this.k22 == "午"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k22 == "未"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k22 == "寅"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k22 == "卯"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k22 == "戌"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k22 == "亥"){
    countGold = countGold + 1;
}
//(1)K13和k23
if(this.k13 == "甲" && this.k23 == "子"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k23 == "丑"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k23 == "申"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k23 == "酉"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k23 == "辰"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k23 == "巳"){
    countGold = countGold + 1;
}
if(this.k13 == "甲" && this.k23 == "午"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k23 == "未"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k23 == "寅"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k23 == "卯"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k23 == "戌"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k23 == "亥"){
    countGold = countGold + 1;
}
//(1)K13和k24
if(this.k13 == "甲" && this.k24 == "子"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k24 == "丑"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k24 == "申"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k24 == "酉"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k24 == "辰"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k24 == "巳"){
    countGold = countGold + 1;
}
if(this.k13 == "甲" && this.k24 == "午"){
    countGold = countGold + 1;
}
if(this.k13 == "乙" && this.k24 == "未"){
    countGold = countGold + 1;
}
if(this.k13 == "壬" && this.k24 == "寅"){
    countGold = countGold + 1;
}
if(this.k13 == "癸" && this.k24 == "卯"){
    countGold = countGold + 1;
}
if(this.k13 == "庚" && this.k24 == "戌"){
    countGold = countGold + 1;
}
if(this.k13 == "辛" && this.k24 == "亥"){
    countGold = countGold + 1;
}

//(1)K14和k21
if(this.k14 == "甲" && this.k21 == "子"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k21 == "丑"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k21 == "申"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k21 == "酉"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k21 == "辰"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k21 == "巳"){
    countGold = countGold + 1;
}
if(this.k14 == "甲" && this.k21 == "午"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k21 == "未"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k21 == "寅"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k21 == "卯"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k21 == "戌"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k21 == "亥"){
    countGold = countGold + 1;
}
//(1)K14和k22
if(this.k14 == "甲" && this.k22 == "子"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k22 == "丑"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k22 == "申"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k22 == "酉"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k22 == "辰"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k22 == "巳"){
    countGold = countGold + 1;
}
if(this.k14 == "甲" && this.k22 == "午"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k22 == "未"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k22 == "寅"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k22 == "卯"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k22 == "戌"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k22 == "亥"){
    countGold = countGold + 1;
}
//(1)K14和k23
if(this.k14 == "甲" && this.k23 == "子"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k23 == "丑"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k23 == "申"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k23 == "酉"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k23 == "辰"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k23 == "巳"){
    countGold = countGold + 1;
}
if(this.k14 == "甲" && this.k23 == "午"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k23 == "未"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k23 == "寅"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k23 == "卯"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k23 == "戌"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k23 == "亥"){
    countGold = countGold + 1;
}
//(1)K14和k24
if(this.k14 == "甲" && this.k24 == "子"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k24 == "丑"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k24 == "申"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k24 == "酉"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k24 == "辰"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k24 == "巳"){
    countGold = countGold + 1;
}
if(this.k14 == "甲" && this.k24 == "午"){
    countGold = countGold + 1;
}
if(this.k14 == "乙" && this.k24 == "未"){
    countGold = countGold + 1;
}
if(this.k14 == "壬" && this.k24 == "寅"){
    countGold = countGold + 1;
}
if(this.k14 == "癸" && this.k24 == "卯"){
    countGold = countGold + 1;
}
if(this.k14 == "庚" && this.k24 == "戌"){
    countGold = countGold + 1;
}
if(this.k14 == "辛" && this.k24 == "亥"){
    countGold = countGold + 1;
}


      

      let countLand = 0;
      //土land
      //1.判断天干K11-K14
      if (this.k11 == "戊" || this.k11 == "己") {
        countLand = countLand + 1;
      }
      if (this.k12 == "戊" || this.k12 == "己") {
        countLand = countLand + 1;
      }
      if (this.k13 == "戊" || this.k13 == "己") {
        countLand = countLand + 1;
      }
      if (this.k14 == "戊" || this.k14 == "己") {
        countLand = countLand + 1;
      }
      //2.判断月柱地支K22
      if (this.k22 == "辰" || this.k22 == "戌" || this.k22 == "丑" || this.k22 == "未") {
        countLand = countLand + 0.5;
      }
      //3.地支藏干K31-K34
      if (this.k31.match("戊")) {
        countLand = countLand + 1;
      }
            if (this.k31.match("己")) {
        countLand = countLand + 1;
      }
            if (this.k32.match("戊")) {
        countLand = countLand + 1;
      }
            if (this.k32.match("己")) {
        countLand = countLand + 1;
      }
                  if (this.k33.match("戊")) {
        countLand = countLand + 1;
      }
            if (this.k33.match("己")) {
        countLand = countLand + 1;
      }
                  if (this.k34.match("戊")) {
        countLand = countLand + 1;
      }
            if (this.k34.match("己")) {
        countLand = countLand + 1;
      }

      //4.天干化合K11跟K32化，K12跟K31、K33化，K13跟K32、K34化，K14跟K33化
              //(1)K11跟K32化 
      if(this.k32.match("己") && !this.k32.match("甲")){
      let jiArray = this.k32.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k11 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k11 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k11 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k11 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k11 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k32.match("己") && this.k32.match("甲")){
           let jiArray = this.k32.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k32.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k11 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k11 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k11 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k11 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k11 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k11 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k11 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k11 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k11 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k11 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k11 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }
      //(2)K12跟K31、K33化 
      //(一)K12跟K31
if(this.k31.match("己") && !this.k31.match("甲")){
      let jiArray = this.k31.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k12 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k12 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k12 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k31.match("己") && this.k31.match("甲")){
           let jiArray = this.k31.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k31.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k12 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }

      //(二)K12跟K33
if(this.k33.match("己") && !this.k33.match("甲")){
      let jiArray = this.k33.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k12 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k12 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k12 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k33.match("己") && this.k33.match("甲")){
           let jiArray = this.k33.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k33.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k12 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k12 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k12 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }
      //(3)K13跟K32、K34化
            //(一)K13跟K32
if(this.k32.match("己") && !this.k32.match("甲")){
      let jiArray = this.k32.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k13 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k13 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k32.match("己") && this.k32.match("甲")){
           let jiArray = this.k32.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k32.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k13 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }

      //(二)K13跟K34
if(this.k34.match("己") && !this.k34.match("甲")){
      let jiArray = this.k34.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k13 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k13 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k34.match("己") && this.k34.match("甲")){
           let jiArray = this.k34.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k34.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k13 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }

//(4)K14跟K33化
if(this.k33.match("己") && !this.k33.match("甲")){
      let jiArray = this.k33.split("己");
      let jiNum = jiArray.length - 1;
      if (this.k13 == "甲" && jiNum == 1) {
        countLand = countLand + 2;
      }else if(this.k13 == "甲" && jiNum == 2){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 3){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 5){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 6){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 7){
countLand = countLand + 8;
      }
      }else if(this.k33.match("己") && this.k33.match("甲")){
           let jiArray = this.k33.split("己");
      let jiNum = jiArray.length - 1;
      let jiaArray = this.k33.split("甲");
      let jiaNum = jiaArray.length - 1;

      if (this.k13 == "甲" && jiNum == 6 && jiaNum == 1) {
        countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 5 && jiaNum == 1){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 1){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 1){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 1){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 1){
countLand = countLand + 3;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 2){
countLand = countLand + 4;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 3){
countLand = countLand + 5;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 4){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 5){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 1 && jiaNum == 6){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 5){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 4){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 4){
countLand = countLand + 7;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 3){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 3 && jiaNum == 2){
countLand = countLand + 6;
      }else if(this.k13 == "甲" && jiNum == 4 && jiaNum == 3){
countLand = countLand + 8;
      }else if(this.k13 == "甲" && jiNum == 2 && jiaNum == 2){
countLand = countLand + 5;
      }


      }

      //5.判断地支六合
      
      if(DiZhiLiuHe.match("子") && DiZhiLiuHe.match("丑")){
          let ziArrayDiZhiLiuHe = DiZhiLiuHe.split("子");
          let ziNumDiZhiLiuHe = ziArrayDiZhiLiuHe.length - 1;
          let chouArrayDiZhiLiuHe = DiZhiLiuHe.split("丑");
          let chouNumDiZhiLiuHe = chouArrayDiZhiLiuHe.length - 1;
          if(ziNumDiZhiLiuHe == 1 && chouNumDiZhiLiuHe == 1){
              countLand = countLand + 1;
          }else if(ziNumDiZhiLiuHe == 1 && chouNumDiZhiLiuHe == 2){
              countLand = countLand + 2;
          }else if(ziNumDiZhiLiuHe == 1 && chouNumDiZhiLiuHe == 3){
              countLand = countLand + 3;
          }else if(ziNumDiZhiLiuHe == 2 && chouNumDiZhiLiuHe == 1){
              countLand = countLand + 2;
          }else if(ziNumDiZhiLiuHe == 3 && chouNumDiZhiLiuHe == 1){
              countLand = countLand + 3;
          }else if(ziNumDiZhiLiuHe == 2 && chouNumDiZhiLiuHe == 2){
              countLand = countLand + 4;
          }
      }

//9.三个地支
      if(SanGeDiZhi.match("辰")){
          let chenArraySanGeDiZhi = SanGeDiZhi.split("辰");
          let chenNumSanGeDiZhi = chenArraySanGeDiZhi.length - 1;
          
          if(chenNumSanGeDiZhi == 3){
              countLand = countLand + 3;
          }
      }
      if(SanGeDiZhi.match("戌")){
          let xuArraySanGeDiZhi = SanGeDiZhi.split("戌");
          let xuNumSanGeDiZhi = xuArraySanGeDiZhi.length - 1;
          
          if(xuNumSanGeDiZhi == 3){
              countLand = countLand + 3;
          }
      }
      if(SanGeDiZhi.match("未")){
          let weiArraySanGeDiZhi = SanGeDiZhi.split("未");
          let weiNumSanGeDiZhi = weiArraySanGeDiZhi.length - 1;
          
          if(weiNumSanGeDiZhi == 3){
              countLand = countLand + 3;
          }
      }
      if(SanGeDiZhi.match("丑")){
          let chouArraySanGeDiZhi = SanGeDiZhi.split("丑");
          let chouNumSanGeDiZhi = chouArraySanGeDiZhi.length - 1;
          
          if(chouNumSanGeDiZhi == 3){
              countLand = countLand + 3;
          }
      }

      //10.判断地支三会
      
      if(DiZhiSanHui.match("辰") && DiZhiSanHui.match("戌") && DiZhiSanHui.match("丑") && DiZhiSanHui.match("未")){
          let chenArrayDiZhiSanHui = DiZhiSanHui.split("辰");
          let chenNumDiZhiSanHui = chenArrayDiZhiSanHui.length - 1;
          let xuArrayDiZhiSanHui = DiZhiSanHui.split("戌");
          let xuNumDiZhiSanHui = xuArrayDiZhiSanHui.length - 1;
          let chouArrayDiZhiSanHui = DiZhiSanHui.split("丑");
          let chouNumDiZhiSanHui = chouArrayDiZhiSanHui.length - 1;
          let weiArrayDiZhiSanHui = DiZhiSanHui.split("未");
          let weiNumDiZhiSanHui = weiArrayDiZhiSanHui.length - 1;
          if(chenNumDiZhiSanHui == 1 && xuNumDiZhiSanHui == 1 && chouNumDiZhiSanHui == 1 && weiNumDiZhiSanHui == 1){
              countLand = countLand + 4;
          }
      }
      //11.判断四柱纳音
      //(1)K11和k21
if(this.k11 == "庚" && this.k21 == "午"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k21 == "未"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k21 == "寅"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k21 == "卯"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k21 == "戌"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k21 == "亥"){
    countLand = countLand + 1;
}
if(this.k11 == "庚" && this.k21 == "子"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k21 == "丑"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k21 == "申"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k21 == "酉"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k21 == "辰"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k21 == "巳"){
    countLand = countLand + 1;
}

 //(1)K11和k22
if(this.k11 == "庚" && this.k22 == "午"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k22 == "未"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k22 == "寅"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k22 == "卯"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k22 == "戌"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k22 == "亥"){
    countLand = countLand + 1;
}
if(this.k11 == "庚" && this.k22 == "子"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k22 == "丑"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k22 == "申"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k22 == "酉"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k22 == "辰"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k22 == "巳"){
    countLand = countLand + 1;
}

 //(1)K11和k23
if(this.k11 == "庚" && this.k23 == "午"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k23 == "未"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k23 == "寅"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k23 == "卯"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k23 == "戌"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k23 == "亥"){
    countLand = countLand + 1;
}
if(this.k11 == "庚" && this.k23 == "子"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k23 == "丑"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k23 == "申"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k23 == "酉"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k23 == "辰"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k23 == "巳"){
    countLand = countLand + 1;
}

//(1)K11和k24
if(this.k11 == "庚" && this.k24 == "午"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k24 == "未"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k24 == "寅"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k24 == "卯"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k24 == "戌"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k24 == "亥"){
    countLand = countLand + 1;
}
if(this.k11 == "庚" && this.k24 == "子"){
    countLand = countLand + 1;
}
if(this.k11 == "辛" && this.k24 == "丑"){
    countLand = countLand + 1;
}
if(this.k11 == "戊" && this.k24 == "申"){
    countLand = countLand + 1;
}
if(this.k11 == "己" && this.k24 == "酉"){
    countLand = countLand + 1;
}
if(this.k11 == "丙" && this.k24 == "辰"){
    countLand = countLand + 1;
}
if(this.k11 == "丁" && this.k24 == "巳"){
    countLand = countLand + 1;
}

//(1)K12和k21
if(this.k12 == "庚" && this.k21 == "午"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k21 == "未"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k21 == "寅"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k21 == "卯"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k21 == "戌"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k21 == "亥"){
    countLand = countLand + 1;
}
if(this.k12 == "庚" && this.k21 == "子"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k21 == "丑"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k21 == "申"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k21 == "酉"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k21 == "辰"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k21 == "巳"){
    countLand = countLand + 1;
}

//(1)K12和k22
if(this.k12 == "庚" && this.k22 == "午"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k22 == "未"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k22 == "寅"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k22 == "卯"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k22 == "戌"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k22 == "亥"){
    countLand = countLand + 1;
}
if(this.k12 == "庚" && this.k22 == "子"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k22 == "丑"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k22 == "申"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k22 == "酉"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k22 == "辰"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k22 == "巳"){
    countLand = countLand + 1;
}

//(1)K12和k23
if(this.k12 == "庚" && this.k23 == "午"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k23 == "未"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k23 == "寅"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k23 == "卯"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k23 == "戌"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k23 == "亥"){
    countLand = countLand + 1;
}
if(this.k12 == "庚" && this.k23 == "子"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k23 == "丑"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k23 == "申"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k23 == "酉"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k23 == "辰"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k23 == "巳"){
    countLand = countLand + 1;
}

//(1)K12和k24
if(this.k12 == "庚" && this.k24 == "午"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k24 == "未"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k24 == "寅"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k24 == "卯"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k24 == "戌"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k24 == "亥"){
    countLand = countLand + 1;
}
if(this.k12 == "庚" && this.k24 == "子"){
    countLand = countLand + 1;
}
if(this.k12 == "辛" && this.k24 == "丑"){
    countLand = countLand + 1;
}
if(this.k12 == "戊" && this.k24 == "申"){
    countLand = countLand + 1;
}
if(this.k12 == "己" && this.k24 == "酉"){
    countLand = countLand + 1;
}
if(this.k12 == "丙" && this.k24 == "辰"){
    countLand = countLand + 1;
}
if(this.k12 == "丁" && this.k24 == "巳"){
    countLand = countLand + 1;
}

//(1)K13和k21
if(this.k13 == "庚" && this.k21 == "午"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k21 == "未"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k21 == "寅"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k21 == "卯"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k21 == "戌"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k21 == "亥"){
    countLand = countLand + 1;
}
if(this.k13 == "庚" && this.k21 == "子"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k21 == "丑"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k21 == "申"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k21 == "酉"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k21 == "辰"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k21 == "巳"){
    countLand = countLand + 1;
}

//(1)K13和k22
if(this.k13 == "庚" && this.k22 == "午"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k22 == "未"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k22 == "寅"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k22 == "卯"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k22 == "戌"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k22 == "亥"){
    countLand = countLand + 1;
}
if(this.k13 == "庚" && this.k22 == "子"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k22 == "丑"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k22 == "申"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k22 == "酉"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k22 == "辰"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k22 == "巳"){
    countLand = countLand + 1;
}

//(1)K13和k23
if(this.k13 == "庚" && this.k23 == "午"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k23 == "未"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k23 == "寅"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k23 == "卯"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k23 == "戌"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k23 == "亥"){
    countLand = countLand + 1;
}
if(this.k13 == "庚" && this.k23 == "子"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k23 == "丑"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k23 == "申"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k23 == "酉"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k23 == "辰"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k23 == "巳"){
    countLand = countLand + 1;
}

//(1)K13和k24
if(this.k13 == "庚" && this.k24 == "午"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k24 == "未"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k24 == "寅"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k24 == "卯"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k24 == "戌"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k24 == "亥"){
    countLand = countLand + 1;
}
if(this.k13 == "庚" && this.k24 == "子"){
    countLand = countLand + 1;
}
if(this.k13 == "辛" && this.k24 == "丑"){
    countLand = countLand + 1;
}
if(this.k13 == "戊" && this.k24 == "申"){
    countLand = countLand + 1;
}
if(this.k13 == "己" && this.k24 == "酉"){
    countLand = countLand + 1;
}
if(this.k13 == "丙" && this.k24 == "辰"){
    countLand = countLand + 1;
}
if(this.k13 == "丁" && this.k24 == "巳"){
    countLand = countLand + 1;

}

//(1)K14和k21
if(this.k14 == "庚" && this.k21 == "午"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k21 == "未"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k21 == "寅"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k21 == "卯"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k21 == "戌"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k21 == "亥"){
    countLand = countLand + 1;
}
if(this.k14 == "庚" && this.k21 == "子"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k21 == "丑"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k21 == "申"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k21 == "酉"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k21 == "辰"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k21 == "巳"){
    countLand = countLand + 1;

}

//(1)K14和k22
if(this.k14 == "庚" && this.k22 == "午"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k22 == "未"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k22 == "寅"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k22 == "卯"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k22 == "戌"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k22 == "亥"){
    countLand = countLand + 1;
}
if(this.k14 == "庚" && this.k22 == "子"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k22 == "丑"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k22 == "申"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k22 == "酉"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k22 == "辰"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k22 == "巳"){
    countLand = countLand + 1;

}

//(1)K14和k23
if(this.k14 == "庚" && this.k23 == "午"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k23 == "未"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k23 == "寅"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k23 == "卯"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k23 == "戌"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k23 == "亥"){
    countLand = countLand + 1;
}
if(this.k14 == "庚" && this.k23 == "子"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k23 == "丑"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k23 == "申"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k23 == "酉"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k23 == "辰"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k23 == "巳"){
    countLand = countLand + 1;

}

//(1)K14和k24
if(this.k14 == "庚" && this.k24 == "午"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k24 == "未"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k24 == "寅"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k24 == "卯"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k24 == "戌"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k24 == "亥"){
    countLand = countLand + 1;
}
if(this.k14 == "庚" && this.k24 == "子"){
    countLand = countLand + 1;
}
if(this.k14 == "辛" && this.k24 == "丑"){
    countLand = countLand + 1;
}
if(this.k14 == "戊" && this.k24 == "申"){
    countLand = countLand + 1;
}
if(this.k14 == "己" && this.k24 == "酉"){
    countLand = countLand + 1;
}
if(this.k14 == "丙" && this.k24 == "辰"){
    countLand = countLand + 1;
}
if(this.k14 == "丁" && this.k24 == "巳"){
    countLand = countLand + 1;

}







      //赋值给五行的数据
      this.water = countWater;

      this.fire = countFire;

      this.tree = countTree;

      this.gold = countGold;

      this.land = countLand;

      // 绘制图表
      var myChart = echarts.init(document.getElementById("main"));
      // 指定图表的配置项和数据
      var option = {
        //标题
        title: {
          text: "五行饼图",
          x: "left", //标题位置
          // textStyle: { //标题内容的样式
          //   color: '#000',
          //   fontStyle: 'normal',
          //   fontWeight: 100,
          //   fontSize: 16 //主题文字字体大小，默认为18px
          // },
        },
        // stillShowZeroSum: true,
        //鼠标划过时饼状图上显示的数据
        tooltip: {
          trigger: "item",
          formatter: "{a}<br/>{b}:{c} ({d}%)",
        },
        //图例
        legend: {
          //图例  标注各种颜色代表的模块
          // orient: 'vertical',//图例的显示方式  默认横向显示
          bottom: 5, //控制图例出现的距离  默认左上角
          left: "center", //控制图例的位置
          // itemWidth: 16,//图例颜色块的宽度和高度
          // itemHeight: 12,
          textStyle: {
            //图例中文字的样式
            color: "#000",
            fontSize: 23,
          },
          data: ["水", "火", "木", "金", "土"], //图例上显示的饼图各模块上的名字
        },
        //饼图中各模块的颜色
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "darkorange", "chartreuse"],
        // 饼图数据
        series: {
          // name: 'bug分布',
          type: "pie", //echarts图的类型   pie代表饼图
          radius: "70%", //饼图中饼状部分的大小所占整个父元素的百分比
          center: ["50%", "50%"], //整个饼图在整个父元素中的位置
          // data:''               //饼图数据
          label:{
              normal:{
                  show:true,
                  formatter:'{b}:{c}({d}%)',
                  fontSize: 20
              }
          },
          data: [
            //每个模块的名字和值
            { name: "水", value: this.water },
            { name: "火", value: this.fire },
            { name: "木", value: this.tree },
            { name: "金", value: this.gold },
            { name: "土", value: this.land },
          ],
          itemStyle: {
            normal: {
              label: {
                show: true, //饼图上是否出现标注文字 标注各模块代表什么  默认是true
                // position: 'inner',//控制饼图上标注文字相对于饼图的位置  默认位置在饼图外
              },
              labelLine: {
                show: true, //官网demo里外部标注上的小细线的显示隐藏    默认显示
              },
            },
          },
        },
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
  },
};
</script>

<style lang="scss" scoped>
#d1 {
  color: bisque;
  color: chartreuse;
  color: darkorange;
}
#five{
    margin-left:200px;
}
</style>
