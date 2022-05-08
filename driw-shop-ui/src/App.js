import Topbar from './components/topbar/Topbar';
import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes
} from "react-router-dom";
import PriceCalculator from './pages/PriceCalculator/PriceCalculator.jsx'
import Home from './pages/home/Home';
import PriceList from './pages/price-list/Price-list';
function App() {
  return (
    <Router>
            <Topbar />
            <div className="container">
              <Routes>
                <Route exact path="/" element={<Home />}></Route>
                <Route path="/calculator" element={<PriceCalculator />}></Route>
                <Route path="/pricelist/:id" element={<PriceList />}></Route>
              </Routes>
            </div>
          </Router>
  );
}

export default App;
