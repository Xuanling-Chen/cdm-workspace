package cdm.base.math;

import cdm.base.math.meta.QuantityGroupsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface QuantityGroups extends RosettaModelObject {
	QuantityGroups build();
	QuantityGroups.QuantityGroupsBuilder toBuilder();
	
	/**
	 */
	List<? extends QuantityGroup> getQuantityGroups();
	final static QuantityGroupsMeta metaData = new QuantityGroupsMeta();
	
	@Override
	default RosettaMetaData<? extends QuantityGroups> metaData() {
		return metaData;
	} 
			
	static QuantityGroups.QuantityGroupsBuilder builder() {
		return new QuantityGroups.QuantityGroupsBuilderImpl();
	}
	
	default Class<? extends QuantityGroups> getType() {
		return QuantityGroups.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("quantityGroups"), processor, QuantityGroup.class, getQuantityGroups());
	}
	
	
	interface QuantityGroupsBuilder extends QuantityGroups, RosettaModelObjectBuilder {
		QuantityGroup.QuantityGroupBuilder getOrCreateQuantityGroups(int _index);
		List<? extends QuantityGroup.QuantityGroupBuilder> getQuantityGroups();
		QuantityGroups.QuantityGroupsBuilder addQuantityGroups(QuantityGroup quantityGroups);
		QuantityGroups.QuantityGroupsBuilder addQuantityGroups(QuantityGroup quantityGroups, int _idx);
		QuantityGroups.QuantityGroupsBuilder addQuantityGroups(List<? extends QuantityGroup> quantityGroups);
		QuantityGroups.QuantityGroupsBuilder setQuantityGroups(List<? extends QuantityGroup> quantityGroups);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("quantityGroups"), processor, QuantityGroup.QuantityGroupBuilder.class, getQuantityGroups());
		}
		
	}
	
	//QuantityGroups.QuantityGroupsImpl
	class QuantityGroupsImpl implements QuantityGroups {
		private final List<? extends QuantityGroup> quantityGroups;
		
		protected QuantityGroupsImpl(QuantityGroups.QuantityGroupsBuilder builder) {
			this.quantityGroups = ofNullable(builder.getQuantityGroups()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends QuantityGroup> getQuantityGroups() {
			return quantityGroups;
		}
		
		@Override
		public QuantityGroups build() {
			return this;
		}
		
		@Override
		public QuantityGroups.QuantityGroupsBuilder toBuilder() {
			QuantityGroups.QuantityGroupsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityGroups.QuantityGroupsBuilder builder) {
			ofNullable(getQuantityGroups()).ifPresent(builder::setQuantityGroups);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityGroups _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantityGroups, _that.getQuantityGroups())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityGroups != null ? quantityGroups.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityGroups {" +
				"quantityGroups=" + this.quantityGroups +
			'}';
		}
	}
	
	//QuantityGroups.QuantityGroupsBuilderImpl
	class QuantityGroupsBuilderImpl implements QuantityGroups.QuantityGroupsBuilder {
	
		protected List<QuantityGroup.QuantityGroupBuilder> quantityGroups = new ArrayList<>();
	
		public QuantityGroupsBuilderImpl() {
		}
	
		@Override
		public List<? extends QuantityGroup.QuantityGroupBuilder> getQuantityGroups() {
			return quantityGroups;
		}
		
		public QuantityGroup.QuantityGroupBuilder getOrCreateQuantityGroups(int _index) {
		
			if (quantityGroups==null) {
				this.quantityGroups = new ArrayList<>();
			}
			QuantityGroup.QuantityGroupBuilder result;
			return getIndex(quantityGroups, _index, () -> {
						QuantityGroup.QuantityGroupBuilder newQuantityGroups = QuantityGroup.builder();
						return newQuantityGroups;
					});
		}
		
	
		@Override
		public QuantityGroups.QuantityGroupsBuilder addQuantityGroups(QuantityGroup quantityGroups) {
			if (quantityGroups!=null) this.quantityGroups.add(quantityGroups.toBuilder());
			return this;
		}
		
		@Override
		public QuantityGroups.QuantityGroupsBuilder addQuantityGroups(QuantityGroup quantityGroups, int _idx) {
			getIndex(this.quantityGroups, _idx, () -> quantityGroups.toBuilder());
			return this;
		}
		@Override 
		public QuantityGroups.QuantityGroupsBuilder addQuantityGroups(List<? extends QuantityGroup> quantityGroupss) {
			if (quantityGroupss != null) {
				for (QuantityGroup toAdd : quantityGroupss) {
					this.quantityGroups.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public QuantityGroups.QuantityGroupsBuilder setQuantityGroups(List<? extends QuantityGroup> quantityGroupss) {
			if (quantityGroupss == null)  {
				this.quantityGroups = new ArrayList<>();
			}
			else {
				this.quantityGroups = quantityGroupss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public QuantityGroups build() {
			return new QuantityGroups.QuantityGroupsImpl(this);
		}
		
		@Override
		public QuantityGroups.QuantityGroupsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityGroups.QuantityGroupsBuilder prune() {
			quantityGroups = quantityGroups.stream().filter(b->b!=null).<QuantityGroup.QuantityGroupBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantityGroups()!=null && getQuantityGroups().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityGroups.QuantityGroupsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityGroups.QuantityGroupsBuilder o = (QuantityGroups.QuantityGroupsBuilder) other;
			
			merger.mergeRosetta(getQuantityGroups(), o.getQuantityGroups(), this::getOrCreateQuantityGroups);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityGroups _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantityGroups, _that.getQuantityGroups())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantityGroups != null ? quantityGroups.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuantityGroupsBuilder {" +
				"quantityGroups=" + this.quantityGroups +
			'}';
		}
	}
}
