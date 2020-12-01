package practice;
/*Maven has a clean life cycle and a build life cycle as well as site life cycle 
 * Eclipse has Maven installed 
 * 1. clean life cycle-	
 * 			1. Pre-clean
 * 			2.Clean	
 * 			3.Post-Clean
 * Clean goal is to delete any previous build directories and reinstall them 
 * 2.Build Life Cycle- there are 9 phases, if we call one of the hierarchy phases it does everything beforehand
 * 						1. Validate - checks program has all the info it needs
 * 						2. Initialize - start initializing the build
 * 						3. Compile - gets all the source code and translates it 
 * 						4. Test Compile - compiles the source code for the test 
 * 						5. Test - runs the profiles given, if no profile given, runs all @test
 * 						6. Package - Once all tests are successful, it will create a package that we can share with others
 * 						7. Verify - run last check-up for package 
 * 						8. Install- creates the package into local repository 
 * 						9. Deploy - put package into remote repository to share 	   	
 */
public class MavenLifeCycle {

}
