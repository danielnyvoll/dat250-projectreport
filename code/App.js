function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Welcome />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/home" element={<PrivateRoute><Home /></PrivateRoute>} />
                <Route path="/createPoll" element={<CreatePoll />} />
                <Route path="/poll/:code" element={<PollVoteDisplay />} />
                <Route path="/pollPage/:pollID" element={<PollData />} />
                <Route path="/ThankYou" element={<ThankYou />} />
            </Routes>
        </Router>
    );
}