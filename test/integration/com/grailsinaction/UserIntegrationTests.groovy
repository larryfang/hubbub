package com.grailsinaction

import static org.junit.Assert.*
import org.junit.*

class UserIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSave() {
        def user = new User("userId":"joe", "password": "avbcer", "homepage": "http://www.abc.com")
        user.save()
        assertNotNull(user.id)
        assertEquals("joe", User.get(user.id).userId)
    }
    @Test
    void testUpdate() {
        def user = new User("userId":"joe", "password": "avberc", "homepage": "http://www.abc.com")
        user.save()
        user.password = "password"
        assertEquals("password", User.get(user.id).password)
    }
    @Test
    void testDelete() {
        def user = new User("userId":"joe", "password": "avbc", "homepage": "http://www.abc.com")
        user.save()
        user.delete()
        assertFalse(User.exists(user.id))
    }
    @Test
    void testEvilSave() {
        def user = new User("userId":"joe", "password": "tiny", "homepage": "www.abc.com")
        assertFalse(user.validate())
        assertTrue(user.hasErrors())



    }
}
