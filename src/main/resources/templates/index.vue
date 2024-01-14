<template>
  <div id="app">
    <h1>線上投票系統</h1>

    <!-- 投票項目列表 -->
    <div>
      <h2>投票項目列表</h2>
      <ul>
        <li v-for="item in voteItems" :key="item.voteNumber">
          {{ item.voteItemN }}
          <button @click="editVoteItem(item)">編輯</button>
          <button @click="deleteVoteItem(item.voteNumber)">刪除</button>
        </li>
      </ul>
    </div>

    <!-- 新增投票項目表單 -->
    <div>
      <h2>新增投票項目</h2>
      <form @submit.prevent="addVoteItem">
        <label for="voteItemN">投票項目名稱:</label>
        <input type="text" id="voteItemN" v-model="newVoteItemN" required />
        <button type="submit">新增</button>
      </form>
    </div>

    <!-- 投票功能 -->
    <div>
      <h2>投票功能</h2>
      <ul>
        <li v-for="item in voteItems" :key="item.voteNumber">
          {{ item.voteItemN }} - {{ item.voteNumber }}
          <input type="checkbox" v-model="selectedVoteItems" :value="item.voteNumber" />
        </li>
      </ul>
      <button @click="vote">投票</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      voteItems: [], // 存放投票項目的陣列
      newVoteItemN: '', // 新增投票項目的名稱
      selectedVoteItems: [], // 用戶選擇的投票項目
    };
  },
  methods: {
    // 取得投票項目列表
    async fetchVoteItems() {
      // 使用 RESTful API 取得後端資料
      const response = await fetch('/api/voteitem');
      const data = await response.json();
      this.voteItems = data;
    },
    // 新增投票項目
    async addVoteItem() {
      await fetch('/api/voteitem', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ voteItemN: this.newVoteItemN }),
      });
      this.newVoteItemN = '';
      this.fetchVoteItems();
    },
    // 編輯投票項目
    editVoteItem(item) {
      console.log('Edit Vote Item:', item);
    },
    // 刪除投票項目
    async deleteVoteItem(voteNumber) {
      await fetch(`/api/voteitem/${voteNumber}`, {
        method: 'DELETE',
      });
      this.fetchVoteItems(); //
    },
    // 投票
    async vote() {
      await fetch('/api/voterecords', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ selectedVoteItems: this.selectedVoteItems }),
      });
      this.selectedVoteItems = [];
      this.fetchVoteItems();
    },
  },
  mounted() {
    this.fetchVoteItems();
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

form {
  margin-bottom: 20px;
}

button {
  margin-left: 10px;
}
</style>
