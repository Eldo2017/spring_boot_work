import {useState,useEffect} from 'react';
import './App.css';
import axios from 'axios';

function App() {
	const [doohan,setDoohan]=useState('');
	const [menuList, setMenuList]=useState([]);
	useEffect(() => {
		axios.get('/api/test')
			 .then(res => {
				console.log(res);
				setDoohan(res.data);
			 })
	})
  return (
    <div className="App">
     <h3>서버에서 들어온 값: {doohan}</h3>
	 <hr/>
	 {
		menuList.map(menu => {
			return (
				<div>{menu.name}</div>
			)
		})
	 }
	 
	 <button onClick={() => {
		axios.get('/api/menuall')
			.then(res => {
				console.log(res);
				setMenuList(res.data);
			})
			.catch(() => {
				console.log("실패");
			})
	 }}>서버에서 메뉴 가져오기</button>
	 
	 <button onClick={() => {
		axios.post('/api/addmenu', {
					restaurant:'상해루 종로점'
					, name: '볶음밥'
					, price: 9500
					, type: 'CH'
					, taste: 'MILD'
		}).then(res => {
			console.log(res);
			
		})
	 }}>메뉴 추가</button>
    </div>
  );
}

export default App;
