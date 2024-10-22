
public class Config {

    /**
     * Indexes into coordinate arrays specifying a location in the map.
     */
    public static final int ROW = 0;
    public static final int COLUMN = 1;

    /**
     * Indexes into the fields/attributes array for each map location (3rd dimension of
     * the map array)
     */
    public static final int NAME = 0;
    public static final int ENTER_TEXT = 1;
    public static final int ENTER_RESULT = 2;
    public static final int NEARBY_TEXT = 3;



    //add additional indexes here for additional field information added to each configuration
    //line.
    public static final int NEARBY_SOUNDS = 4;
    public static final int END_SOUNDS = 5;

    /**
     * Values within the location fields/attributes that are used for game logic other than
     * simply printing out.
     */
    //In name field, designates the starting location of the player
    public static final String NAME_START = "start";

    //The result of the player entering the field.
    public static final String RESULT_RANDOM_MOVE = "randomMove";
    public static final String RESULT_WIN = "win";
    public static final String RESULT_LOSE = "lose";
    //add additional game logic fields here (not text fields that are simply printed).

    /**
     * Values used by the player to navigate through the map.
     */
    public static final String MOVE_UP = "w";
    public static final String MOVE_DOWN = "s";
    public static final String MOVE_LEFT = "a";
    public static final String MOVE_RIGHT = "d";
    public static final String NEARBY = "n";
    public static final String QUIT = "q";
    //add additional game control characters here, throwing, shooting, etc.

}

/*
Your READ ME notes to the Grader
Describe your enhancements to the program, map, etc. here.  You may include a link to a
YouTube video of a maximum of 2 minutes demonstrating your program.

0) Overview of your changes or a YouTube video link (max 2 minutes)

https://www.youtube.com/watch?v=SpAnPhLAhdY. - I tried to make this as concise as possible to explain the code
and demonstrate every sound in the program, please watch the whole thing!

Not stated in video: the constants NEARBY_SOUNDS and END_SOUNDS are added, so that they can be called using the
fields array. They are equal to 4 and 5 respectively.


1) Configuration Example: Contents of your own configuration (.advcfg) file

My configuration file (mando.advcfg) contains multiple rows of fields, with contents divided by "/". It is organized
by coordinates, name of an obstruction, text when hitting an obstruction, the result of hitting the obstruction,
text which alerts the user of a nearby obstruction, sound that plays during these alerts, and lastly, the
end sounds, which play at the very end of a game (either in a win or loss). There are 11 total sounds that are played,
although one (intro.wav) is not played from the configuration file as it only needs to be played at the very beginning of the
game from the main method. Another is not played from the configuration file as it is the footstep sound effect that
plays after every movement, activated from the enter method. Nearby sounds are played from senseNearby, and win/loss
sounds are played from enter.

Coordinates/Name/Enter Text/Enter Result/Nearby Text/Nearby Sound/End Sound/
8,6/size/This is the size of the map///
0,4/start/Welcome to the planet Nevarro. Moff Gideon's imperial forces have stolen your Beskar armor - you must traverse through the desert to retrieve it.////
7,0/rancor/You've been killed by a rancor beast./lose/A wild creature looms.../rancor.wav/rancorkill.wav/
5,4/seismic charge/SEISMIC CHARGES!/lose/Sounds like a ship overhead.../ship.wav/seismiccharge.wav/
3,1/jawas/Jawas captured you in their sandcrawler. You escaped, but are not where you were captured./randomMove/Sounds like a vehicle driving by.../sandcrawler.wav/
1,2/stormtroopers/You've been spotted by Stormtroopers! You ran somewhere else to evade them./randomMove/Sounds like someone's on... comms?/stormtrooper.wav/
2,4/jetpack/Your jetpack malfunctioned and flew you to another spot./randomMove/Those sounds are coming from your jetpack. Let's hope nothing comes of it.../jetpack.wav/
4,1/Beskar/You have found your Beskar armor hanging on a post. It's time to leave Nevarro and put a stop to Moff Gideon./win/Something is clanking in the wind.../beskar_clank.wav/victory.wav/

2) Configuration Description: Describe unique elements in your configuration file
The first unique element in my configuration file is within the start field. When the code is ran, the introductory text
is printed for the user to read, introducing him to a planet in Star Wars. Every obstacle in my program is within the
Star Wars universe - that is the theme. Along with this text, playSound is used to play a short snippet of The Mandalorian
theme, as that is who the user is playing as. As this is not a nearby or end sound and I only want it to be played once,
playSound("intro.wav") is called in beginning of the main method.

There are three obstacles that place the user in a new random location (jawas, stormtroopers, jetpack malfunction),
two obstacles that make you lose the game (rancor beast and seismic charges), and one obstacle that makes you
win (beskar armor). Every obstacle has a nearby sound, but only win/loss obstacles have a sound when the player is on
their location.

When jawa's coordinates (3,1) are hit, text prints that states they were captured in a sandcrawler and
ended up in a new location after escaping, as it was on the move. The sound that plays when jawas are nearby is a short
sandcrawler sound effect from Star Wars, along with text that implies there is a vehicle driving by.

When stormtroopers' coordinates (1,2) are hit, text prints that states you were seen by the troopers and ran away, ending
up in a new location. The sound that plays when stormtroopers are nearby is a comms sound effect to mimic their
transmissions, along with text that implies there is someone on comms.

When jetpack's coordinates (2,4) are hit, text prints that states your jetpack is malfunctioning and misfiring, ending
you up in a new location. There is no real 'obstacle' in the way here, as opposed to a monster for example. Hitting the spot
simply simulates the jetpack acting up. The sound that plays when you have a chance of malfunction is a hardware glitch
sound effect, along with text that implies there may be an issue with your jetpack - random chance if you hit the
coordinates or not after.

When rancor's coordinates (7,0) are hit, text prints that states you were killed by the rancor, making you lose the game.
When killed by it, a roughly 8 second sound effect of a rancor eating from Star Wars is played. The sound that plays
when the rancor is nearby is a rancor growling sound effect, along with text that tells the user that there is a
creature nearby.

When seismic charge's coordinates (5,4) are hit, text prints which bluntly emphasizes the fact that seismic charges are
incoming, to emphasize their fast pace and simulate getting caught by surprise. This also makes you lose the game. When
hit by them, the seismic charge sound effect from Star Wars: Episode II is played for roughly 8 seconds. The sound that
plays when the seismic charge is nearby is Slave I engine sound effects from Star Wars, because that is the ship that
drops seismic charges in the movie. Its nearby text implies there is a ship nearby in the sky.

Lastly, there is the victory obstacle, the beskar armor. This is an honor for Mandalorians to don, and that is who you
play as. When their coordinates (4,1) are hit, the theme continues from where it left off at the start coordinates in
the beginning of the game. I wanted to add a nearby sound for this, and the only sound that made sense was metal clanking,
which is what plays. However, to make this make sense (metal clanking with nothing around), I state that the beskar is
found hanging on a post. The nearby text implies there is a sound of metal clanking. And finally, as the win condition
is met, the text states you can leave Nevarro and go after Moff Gideon, an Imperial antagonist from The Mandalorian.

3) writeMap Output: Example output of the writeMap method for your configuration file.

This is the player's start location, taken at (0,4), represented by "X", with open spots represented by "+".
       +              +              +              +              +       X       +
       +              +        stormtroopers        +              +              +
       +              +              +              +           jetpack           +
       +            jawas            +              +              +              +
       +            Beskar           +              +              +              +
       +              +              +              +       seismic charges       +
       +              +              +              +              +              +
    rancor            +              +              +              +              +

4) Choose at least 1 of the following ways you extended the game and describe them:
  a) Tools: added your own tools/weapons and use of them in the game
  b) Audio: playing of audio files when sensing the neighbors, rather than simply text
Every obstacle in my map plays a sound when nearby, and obstacles that cause wins and losses all play a sound when entered.
This is further detailed in each respective paragraph of question 2.
  c) Test Cases: adding test cases to TestAdventure that thoroughly test the methods you wrote.

testParseCoordinates() thoroughly tests parseCoordinates(). First, a normal string of "20,6" is tested, and the expected
result is an array of {20,6}. Another set of numbers is tested like this. Then, just the number 200 is the input string,
expects the method to return null, as two numbers are needed for coordinates. Then, the word "public" is the string, again
expecting a null return as only numbers a comma, and whitespace should be in the string. Then, the string "8,  6" is tested,
to make sure the {8,6} array can be created even with space in the input string. Lastly, "text,  6" is expected to return
null as there should be no letters in the string. If expected results are not equal to actual results, both the expected and
actual result are printed, boolean error is set to true, and an error statement is printed.

testParseFields() thoroughly tests parseFields() to make sure it separates text correctly. Each index its returned array
should be respective to the text separated by /'s in the mando.advcfg file. Blank fields are kept, and the trim() method
edits every field. First, the string "size/This is the size of the map//" is tested, with the expected array being
{"size", "This is the size of the map", "", ""}. Then, " //  /" is tested with the expected array being {"","","",""}.
Lastly, "*" is tested with the expected array being {*}. If expected results are not equal to actual results, both the expected and
actual result are printed, boolean error is set to true, and an error statement is printed.

testDetermineLocation() thoroughly tests determineLocation() to make sure new player coordinates are accurate after the
player inputs either "w", "a", "s", or "d". The test map array for these movements has 10 rows and 6 columns. Each direction
is tested normally first, so that either the new player location is made sure to either add or subtract values depending
on "s"/"d" and "w"/"a", respectively. Then, wrapping is tested. This makes sure that if the row or column array is incremented
above the map's upper bounds, or decremented below 0, the new location simply returns to the other side of the index's bounds.
For example, when "s" is inputted at a starting location of {3,5}, the new location is expected to be {3,0}. Wrapping is tested
four times, once in every direction. So there are eight total tests in this test method.If expected results are not equal to
actual results, both the expected and actual result are printed, boolean error is set to true, and an error statement is printed.

  d) Your Own: describe any other changes or additions we should consider for credit.
Mentioned in video, but a try catch block is used to extend sound audio before game is ended. java.util.concurrent.TimeUnit
is imported to do this. Print debug lines in the main method have been deleted of course, and the file that is read is
named "mando.advcfg." And as aforementioned, additional fields have been added for nearby sounds and loss sounds.
"Thanks for playing!" has been changed to "Thank you for playing."


 */
