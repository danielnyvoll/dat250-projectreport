@GetMapping("/{id}")
public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
    Optional<Poll> poll = pollService.findById(id);
    if (poll.isPresent()) {
        return ResponseEntity.ok(poll.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}
