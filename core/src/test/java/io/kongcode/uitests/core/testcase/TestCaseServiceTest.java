package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by joao on 05/03/16.
 */
public class TestCaseServiceTest {

    @Test public void testCreate() throws Exception {
        TestCase entity = TestCase.builder().build();

        TestCaseRepository repository = mock(TestCaseRepository.class);
        when(repository.save(entity)).thenReturn(entity);

        TestCase.TestCaseBuilder builder = mock(TestCase.TestCaseBuilder.class);
        TestCaseService service = new TestCaseServiceImpl(repository);
        when(builder.build()).thenReturn(entity);

        assertEquals(entity, service.create(builder));
        verify(repository).save(entity);
    }
}
