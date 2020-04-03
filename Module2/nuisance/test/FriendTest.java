package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the constructor and the public methods from class F.
 * This test class should not be modified.
 */
class FriendTest {
	private Friend f = new Friend("Jane", 27, Hobby.MUSIC);

	@Test
	void friend_initializesNameAgeAndHobby() {
		Friend f1 = new Friend("Caleb", 20, Hobby.SPORTS);
		assertEquals("Caleb(20) SPORTS", f1.toString());
	}
	
	@Test
	void chill_returnsNamePlusMessage() {
		assertTrue(f.chill().matches("Jane is chilling.?"));
	}

	@Test
	void play_EmptyArray_ReturnsStringWithNoFriends() {
		Friend[] friends = new Friend[0];
		assertTrue(f.play(friends).matches("[P|p]laying MUSIC.?"));
	}

	@Test
	void play_1FriendInArray_ReturnsStringWith1Friends() {
		Friend[] friends = new Friend[] {
				new Friend("Billy", 75, Hobby.GAMES)
				};
		assertTrue(f.play(friends).matches("[P|p]laying MUSIC with Billy.?"));
	}
	
	@Test
	void play_2FriendsInArray_ReturnsStringWith2Friends() {
		Friend[] friends = new Friend[] {
				new Friend("Billy", 75, Hobby.GAMES),
				new Friend("Riley", 43, Hobby.SPORTS)
				};
		assertTrue(f.play(friends).matches("[P|p]laying MUSIC with Billy and Riley.?"));
	}
	
	@Test
	void play_4FriendsInArray_ReturnsStringWith3Friends() {
		Friend[] friends = new Friend[] {
				new Friend("Billy", 75, Hobby.GAMES),
				new Friend("Riley", 43, Hobby.SPORTS),
				new Friend("Ellie", 34, Hobby.GAMES)
				};
		assertTrue(f.play(friends).matches("[P|p]laying MUSIC with Billy, Riley, and Ellie.?"));
	}	
	
	@Test
	void play_4FriendsInArray_ReturnsStringWith4Friends() {
		Friend[] friends = new Friend[] {
				new Friend("Billy", 75, Hobby.GAMES),
				new Friend("Riley", 43, Hobby.SPORTS),
				new Friend("Ellie", 34, Hobby.GAMES),
				new Friend("Jessie", 39, Hobby.MUSIC)
				};
		assertTrue(f.play(friends).matches("[P|p]laying MUSIC with Billy, Riley, Ellie, and Jessie.?"));
	}
	
	@Test
	void toString_returnsNameAgeInParenthesisAndHobby() {
		assertEquals("Jane(27) MUSIC", f.toString());
	}

}
