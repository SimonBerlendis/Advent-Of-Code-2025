import java.math.BigInteger

/**
 * Returns a progression that goes over the same range with the given step.
 */
infix fun ClosedRange<BigInteger>.step(step: BigInteger = 1.toBigInteger()): BigIntegerProgression {
    if (step <= BigInteger.ZERO) throw IllegalArgumentException("Step must be positive, was: $step.")
    return BigIntegerProgression.fromClosedRange(start, endInclusive, step)
}

/**
 * Returns a progression that goes over the same range with the given step.
 */
infix fun BigIntegerProgression.step(step: BigInteger = 1.toBigInteger()): BigIntegerProgression {
    if (step <= java.math.BigInteger.ZERO) throw IllegalArgumentException("Step must be positive, was: $step.")
    return BigIntegerProgression.fromClosedRange(first, last, if (this.step > java.math.BigInteger.ZERO) step else -step)
}

/**
 * A progression of values of type `BigInteger`.
 */
open class BigIntegerProgression
internal constructor(start: BigInteger, endInclusive: BigInteger, step: BigInteger)
    : Iterable<BigInteger> {
    init {
        if (step == BigInteger.ZERO) throw IllegalArgumentException("Step must be non-zero")
    }

    /**
     * The first element in the progression.
     */
    val first: BigInteger = start

    /**
     * The last element in the progression.
     */
    val last: BigInteger = getProgressionLastElement(start, endInclusive, step)

    /**
     * The step of the progression.
     */
    val step: BigInteger = step

    override fun iterator(): BigIntegerIterator = BigIntegerProgressionIterator(first, last, step)

    /** Checks if the progression is empty. */
    public open fun isEmpty(): Boolean = if (step > BigInteger.ZERO) first > last else first < last

    override fun equals(other: Any?) =
        other is BigIntegerProgression && (isEmpty() && other.isEmpty() ||
                first == other.first && last == other.last && step == other.step)

    override fun hashCode() = if (isEmpty()) -1 else (31 * (31 * first.hashCode() + last.hashCode()) + step.hashCode())

    override fun toString() = if (step > BigInteger.ZERO) "$first..$last step $step" else "$first downTo $last step ${-step}"

    private fun getProgressionLastElement(start: BigInteger, end: BigInteger, step: BigInteger): BigInteger {
        fun mod(a: BigInteger, b: BigInteger): BigInteger {
            val mod = a % b
            return if (mod >= 0.toBigInteger()) mod else mod + b
        }

        fun differenceModulo(a: BigInteger, b: BigInteger, c: BigInteger): BigInteger {
            return mod(mod(a, c) - mod(b, c), c)
        }

        return when {
            step > 0.toBigInteger() -> if (start >= end) end else end -  differenceModulo(end, start, step)
            step < 0.toBigInteger() -> if (start <= end) end else end + differenceModulo(start, end, -step)
            else -> throw kotlin.IllegalArgumentException("Step is zero.")
        }
    }

    companion object {
        /**
         * Creates IntProgression within the specified bounds of a closed range.

         * The progression starts with the [rangeStart] value and goes toward the [rangeEnd] value not excluding it, with the specified [step].
         * In order to go backwards the [step] must be negative.
         */
        fun fromClosedRange(rangeStart: BigInteger, rangeEnd: BigInteger, step: BigInteger): BigIntegerProgression = BigIntegerProgression(rangeStart, rangeEnd, step)
    }
}

/** An iterator over a sequence of values of type `BigInteger`. */
abstract class BigIntegerIterator : Iterator<BigInteger> {
    override final fun next() = nextBigInteger()

    /** Returns the next value in the sequence without boxing. */
    public abstract fun nextBigInteger(): BigInteger
}

fun Iterable<BigInteger>.sum(): BigInteger = fold(0.toBigInteger(), { acc: BigInteger, i: BigInteger -> acc + i })

/**
 * An iterator over a progression of values of type `BigInteger`.
 * @property step the number by which the value is incremented on each step.
 */
class BigIntegerProgressionIterator(first: BigInteger, last: BigInteger, val step: BigInteger) : BigIntegerIterator() {
    private val finalElement = last
    private var hasNext: Boolean = if (step > BigInteger.ZERO) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun nextBigInteger(): BigInteger {
        val value = next
        if (value >= finalElement) {
            if (!hasNext) throw NoSuchElementException()
            hasNext = false
        }
        else {
            next += step
        }
        return value
    }
}