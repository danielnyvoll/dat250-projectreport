@PostMapping
public Poll createPoll(@RequestBody Poll poll, @RequestHeader(name = "Authorization") String idToken) {
    // Extract the Bearer token
    idToken = idToken.replace("Bearer ", "");

    // Decode the ID token to get the Firebase UID
    String firebaseUID = FirebaseFunctions.getUidFromToken(idToken);

    // Save the question first
    Question savedQuestion = questionService.save(poll.getQuestion());
    poll.setQuestion(savedQuestion);
    
    // Find the user by Firebase UID
    User user = userService.findByFirebaseUID(firebaseUID)
            .orElseThrow(() -> new RuntimeException("User not found with Firebase UID: " + firebaseUID));

    // Associate the poll with the user
    poll.setUser(user);

    // Generate a unique code for the poll
    String uniqueCode = PollCodeGenerator.generateCode();
    poll.setCode(uniqueCode);

    Poll savedPoll = pollService.save(poll);

    dweetioController.sendToDweet(savedPoll);

    return savedPoll;
}
